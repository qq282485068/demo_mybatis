DROP PROCEDURE IF EXISTS p_test;
DELIMITER //  
/*
 * 测试存储过程
 * @param p_user_id id(不可为空或为0)
 * @return p_result 1：成功; -1：执行失败回滚
 */
CREATE PROCEDURE p_test(IN p_community_id INT,OUT p_result TINYINT)
BEGIN
	
	-- 异常标志
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET t_error = 1;
	
	SET autocommit = 0;
	START TRANSACTION;
	
	-- code ... 
	
	IF t_error = 0 THEN
		SET p_result = 1;
		COMMIT;
	ELSE
		SET p_result = -1;
		ROLLBACK;
	END IF;
	
END//
DELIMITER ; 
