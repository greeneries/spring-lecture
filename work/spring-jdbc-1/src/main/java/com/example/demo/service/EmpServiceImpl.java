package com.example.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.example.demo.dao.EmpDao;
import com.example.demo.model.Emp;

// 클래스에 트랜잭션 설정을 하면 이 안에 있는 모든 메소드에 트랜잭션이 적용됩니다.
// 서비스 메소드에서 다수의 DAO 메소드를 호출하면, 그 메소드 모두 하나의 트랜잭션
// 단위로 처리됩니다.
// 밑에 설정은 모두 기본값, 생략해도됨)
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, timeout = -1, readOnly = false)
@Service
public class EmpServiceImpl implements EmpService {
// @Autowired
	@Resource(name = "empDaoImpl")
	private EmpDao empDao;
	
	@Autowired
	private DataSourceTransactionManager transactionManager;


// 트랜잭션은 일종의 어라운드 어드바이스 입니다.
// 이 어드바이스는 try-catch 로직을 갖고 있어서
// 서비스 메소드 또는 서비스 메소드에서 호출하는 DAO 메소드에서
// 예외가 발생하는 경우 어드바이스에 catch 블록이 작동하게 되고
// 롤백이 처리됩니다.

	@Override
	public int insert(Emp emp) throws Exception {
		DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		// 아래 설정은 모두 디폴트 값을 사용하고 있다.
		transactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		transactionDefinition.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);
		transactionDefinition.setTimeout(-1);
		transactionDefinition.setReadOnly(false);
		TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
		int affected = 0;
		try {
			// 상단 부분 코드 : Around:Before Advice
			// ************************************
			// Delegation: 타겟 메소드의 핵심로직을 호출한다.
			affected = empDao.insert(emp);
			// ************************************
			// 하단 부분 코드 : Around:After Advice
			transactionManager.commit(transactionStatus);
		} catch (Exception e) {
			transactionManager.rollback(transactionStatus);
			throw e;
		}
		return affected;
	}

	@Override
	public int update(Emp emp) {
		return empDao.update(emp);
	}

	@Override
	public int delete(int empno) {
		return empDao.delete(empno);
	}

// 메소드 위에 설정이 클래스 위에 한 설정보다 우선적으로 적용됩니다.
// 조회 쿼리는 읽기전용임을 통보하여 격리시간을 줄이도록 노력합니다.
	@Transactional(readOnly = true)
	@Override
	public List<Emp> findAll() {
		return empDao.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public int count() {
		return empDao.count();
	}

	@Transactional(readOnly = true)
	@Override
	public Emp findOne(int empno) {
		return empDao.findOne(empno);
	}
}