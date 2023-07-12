package com.prolim.EndProjectP3;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseHistoryRepo extends JpaRepository<PurchaseHistory, Integer>{
	List<PurchaseHistory>findByCname(String Cname);
	List<PurchaseHistory>findBytDate(Date date);
}
