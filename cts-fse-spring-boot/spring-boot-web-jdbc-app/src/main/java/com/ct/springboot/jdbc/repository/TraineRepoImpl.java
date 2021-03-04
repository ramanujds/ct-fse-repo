package com.ct.springboot.jdbc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ct.springboot.jdbc.exception.TraineeNotFoundException;
import com.ct.springboot.jdbc.model.Trainee;
@Repository
public class TraineRepoImpl implements TraineeRepo {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class TraineeRowMapper implements RowMapper<Trainee>{
		@Override
		public Trainee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Trainee trainee=new Trainee();
			trainee.setTraineeId(rs.getInt("traineeId"));
			trainee.setTraineeName(rs.getString("traineeName"));
			trainee.setEmail(rs.getString("email"));
			Date dob=rs.getDate("dob");
			trainee.setDob(LocalDate.of(dob.getYear(), dob.getMonth()+1, dob.getDate()));
			return trainee;
			
		}
	}

	@Override
	public Trainee addTrainee(Trainee trainee) {
		System.out.println(trainee);
		
		int updated=jdbcTemplate.update("insert into trainee values(?,?,?,?)",new Object[] {
				trainee.getTraineeId(),trainee.getTraineeName(),trainee.getEmail(),trainee.getDob()
		});
		
		return updated!=0?trainee:null;
	}

	@Override
	public Trainee getTraineeById(int traineeId) {
		try {
		return Optional.of(jdbcTemplate.queryForObject("select * from trainee where traineeId=?",new Object[] {
			traineeId
		},new BeanPropertyRowMapper<Trainee>(Trainee.class))).get();
		}
		catch (EmptyResultDataAccessException e) {
			throw new TraineeNotFoundException("Trainee with ID: "+traineeId+" Not Found");
		}
	}

	@Override
	public boolean deleteTraineeById(int traineeId) {
		 int deleted=jdbcTemplate.update("delete from trainee where traineeId=?", new Object[] {
		            traineeId
		        });
		 return deleted!=0;
	}

	@Override
	public List<Trainee> getAllTrainees() {
		return jdbcTemplate.query("select * from trainee", new TraineeRowMapper());
	}

}
