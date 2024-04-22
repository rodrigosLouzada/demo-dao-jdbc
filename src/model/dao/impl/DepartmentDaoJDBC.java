package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

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
				+ "(Name)"
				+ "VALUES "
				+ "?",
				Statement.RETURN_GENERATED_KEYS);
		
		st.setString(1, obj.getName());
		
		int rowsaff = st.executeUpdate();
		
		if( rowsaff > 0) {
			
			ResultSet rs = st.getGeneratedKeys();
			
			if(rs.next()) {
				obj.setId( rs.getInt(1));
			}
			
		}
			
		}catch (Exception e) {
			// TODO: handle exception
		}

	}
	

	@Override
	public void update(Department obj) {
		PreparedStatement st =  null;
		
		try { st = conn.prepareStatement("UPDATE Department "
				+ "SET Id = ?, Name = ?");
		
			st.setInt(1, obj.getId());
			st.setString(2, obj.getName());
			
			int rowsaff = st.executeUpdate();
			
			if(rowsaff == 0) {
				throw new DbException("try again, no updates!");
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
				+ "WHERE Id = ?");
		
			st.setInt(1, id);
			int rowsff = st.executeUpdate();
		
			if(rowsff == 0) {
				throw new DbException("error, no rows affected, try an id that exists");
			
		}
			
				
		}catch (Exception e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public Department findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> findALL() {
		// TODO Auto-generated method stub
		return null;
	}

}
