package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {
	
	private Connection conn;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	
	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;
		
		try { st = conn.prepareStatement("INSERT INTO department "
				+ "(Name) "
				+ "VALUES "
				+ "(?)",
				Statement.RETURN_GENERATED_KEYS);
		
		st.setString(1, obj.getName());
		
		int rowsaff = st.executeUpdate();
		
		
		if(rowsaff > 0) {
			
			ResultSet rs = st.getGeneratedKeys();
			
			if(rs.next()) {
				obj.setId(rs.getInt(1));
			}	
		}
			
		}catch (Exception e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
	}
	

	@Override
	public void update(Department obj) {
		PreparedStatement st =  null;
		
		try { st = conn.prepareStatement(
				"UPDATE Department "
				+ "SET Name = ? "
				+ "WHERE ID = ?");
		
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());

			
			int rowsaff = st.executeUpdate();
			
			if(rowsaff == 0) {
				throw new DbException("try again, no uptdates, "
						+ "departaments founds with this ID updates!");
			}
			
		}catch (Exception e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	
	
	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("DELETE FROM Department "
				+ "WHERE Id = (?)");
		
			st.setInt(1, id);
			int rowsff = st.executeUpdate();
		
			if(rowsff == 0) {
				throw new DbException("error, no rows affected, try an id that exists");
			
		}
			
				
		}catch (Exception e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT department.* "
					+"FROM department "
					+ "WHERE Id = (?)");
			
			st.setInt(1, id);
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getInt(1));
				dep.setName(rs.getString(2));
				return dep;
			}
			
			
			
		}catch (Exception e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
		
		
		
		return null;
	}

	@Override
	public List<Department> findALL() {
		PreparedStatement st = null;
		ResultSet rs= null;
		
		try {
			st = conn.prepareStatement("SELECT department.* "
					+ "FROM department "
					+"ORDER BY Name");
			
			rs = st.executeQuery();
			
			List<Department> list = new ArrayList<>();
			// Map<Integer, Department> map = new HashMap<>(); not necessary

			while(rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getInt("Id"));
				dep.setName(rs.getString("Name"));
				
				list.add(dep);

			}
			return list;
			
			

		}catch (Exception e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

}
