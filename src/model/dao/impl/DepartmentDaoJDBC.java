package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
				+ "(Id, Name)"
				+ "VALUES "
				+ "?, ?",
				st.RETURN_GENERATED_KEYS);
		
		st.setInt(1, obj.getId());
		st.setString(2, obj.getName());
		
		int rowsaff = st.executeUpdate();
		
		if( rowsaff > 0) {
			
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
