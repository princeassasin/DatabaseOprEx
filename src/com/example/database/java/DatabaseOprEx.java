package com.example.database.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DatabaseOprEx {

	public static void main(String[] args) {
		
			Connection con;
			Statement stm;
			ResultSet rlt;
			ResultSetMetaData rslt;

			int EmpId, EmpAge;
			String EmpName, EmpDepartment;
			float EmpSalary;
			
			int choice, nof;
			
			try{
				
				Class.forName("org.h2.Driver");
				
				con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/sriram","Sriram","Mathiram9535!@");
				
				stm = con.createStatement();
				
				InputStreamReader in = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(in);
				
				while (true) {
					
					 System.out.println("Enter your choice");
		                System.out.println("1. To Retrieve Data ");
		                System.out.println("2. To Insert Data ");
		                System.out.println("3. To Update Data ");
		                System.out.println("4. To Delete Data ");
		                System.out.println("5. To Exit  ");
		                
		                choice = Integer.parseInt(br.readLine());
		                
		                switch(choice)
		                {
		                	case 1:
		                		rlt = stm.executeQuery("select * from EMPLOYEE");
		                		rslt = rlt.getMetaData();
		                		nof = rslt.getColumnCount();
		                		System.out.println("-------------------------------------------------");
		                		for(int i=1;i<nof;i++){
		                			System.out.println(rslt.getColumnName(i)+"\t\t");
		                		}
		                		System.out.println(" ");
		                		System.out.println("-------------------------------------------------");
		                		while (rlt.next()) {
		                		     System.out.print(rlt.getInt("EMPID"));
		                                System.out.print("\t\t");
		                                System.out.print(rlt.getString("EMPNAME"));
		                                System.out.print("\t\t");
		                                System.out.print(rlt.getInt("EMPAGE"));
		                                System.out.print("\t\t");
		                                System.out.print(rlt.getFloat("EMPSALARY"));
								}
		                		System.out.println(" ");
		                		System.out.println("-------------------------------------------------");
		                		break;
		                		case 2:
		                			 System.out.println();
		                			 System.out.println("Enter Employee ID");
		                             EmpId = Integer.parseInt(br.readLine());
		                             
		                             System.out.println("Enter Employee Name");
		                             EmpName = br.readLine();
		                             
		                             System.out.println("Enter Employee Age");
		                             EmpAge = Integer.parseInt(br.readLine());
		                             
		                             System.out.println("Enter Employee Salary");
		                             EmpSalary = Float.parseFloat(br.readLine());
		                             
		                             stm.execute("insert into EMPLOYEE values("+EmpId+","+EmpName+","+EmpAge+","+EmpSalary+")");
		                             System.out.println("Record Inserted");
		                            
		                         
		                        break;
		                             
		                        case 3:
		                        	System.out.println("Enter values to be edited");
		                        	
		                        	System.out.println("Enter Employee Id");
		                        	EmpId = Integer.parseInt(br.readLine());
		                        	System.out.println("Enter Employee Name");
		                        	EmpName = br.readLine();
		                        	System.out.println("Enter Employee Age");
		                        	EmpAge = Integer.parseInt(br.readLine());
		                        	System.out.println("Enter Employee Salary");
		                        	EmpSalary = Float.parseFloat(br.readLine());
		                        	
		                             stm.execute("update EMPLOYEE set EMPNAME='"+EmpName+"',EMPSALARY="+EmpSalary+"where EMPID="+EmpId);
		                             System.out.println("Records loaded");
		                             break;
		                             
		                             case 4:
		                            	 System.out.println("Enter Employee ID to be deleted");
		                             EmpId = Integer.parseInt(br.readLine());
		                                                    
		                             stm.execute("delete from EMPLOYEE where EMPID="+EmpId);
		                             System.out.println("Record Deleted");
		                         break;
		                         
		                         case 5:
		                             System.exit(0);
		                         break;
		                             }
		  
				}
			
			
			}
			catch(Exception ee){
				
				System.out.println(ee);
			}
	}

}
