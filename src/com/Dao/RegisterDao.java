package com.Dao;
import com.Model.*;
import java.sql.*;
import java.util.*;
import java.sql.Connection;

import com.Model.Register;
public class RegisterDao {

	Connection con=null;
	MyConnection m=new MyConnection();
	PreparedStatement pstate=null;
	int i=0;
	public boolean validateUser(Login lobj)
	{
		boolean b=false;
		con=m.getConnection();
		try
		{
			PreparedStatement ps=con.prepareStatement("select * from accountinfo where username=? and password=?");
			ps.setString(1,lobj.getUname());
			ps.setString(2,lobj.getPass());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				b=true;
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return b;
	}
	public int createAccount(Register r)
	{

		con=m.getConnection();
		try
		{
			pstate=con.prepareStatement("insert into AccountInfo values(?,?,?,?,?)");
			pstate.setInt(1,r.getAccno());
			pstate.setString(2,r.getCustname());
			pstate.setDouble(3,r.getAccbal());
			pstate.setString(4,r.getUname());
			pstate.setString(5, r.getPass());
			i=pstate.executeUpdate();
			con.close();

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return i;
	}
	public List<Register> DisplayAccount()
	{
		ResultSet rs=null;
		Register r=null;
		LinkedList<Register> lst=new LinkedList<>();
		con=m.getConnection();
		Statement state=null;
		String str=null;
		int i=0;
		try
		{
			state=con.createStatement();
			rs=state.executeQuery("select * from accountinfo");
					
			while(rs.next())
			{
				r=new Register();
				System.out.println(rs.getInt(1));
				r.setAccno((rs.getInt(1)));
				r.setCustname((rs.getString(2)));
				r.setAccbal(rs.getDouble(3));
				r.setUname((rs.getString(4)));
				r.setPass((rs.getString(5)));
				lst.add(r);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return lst;
	}
	public List<Register> SearchAccount(int accno)
	{
		List<Register> lst=null;
		con=m.getConnection();
		try
		{
			PreparedStatement ps=con.prepareStatement("select * from AccountInfo where accno=?");
			ps.setInt(1,accno);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				Register r=new Register();
				r.setAccno(rs.getInt(1));
				r.setCustname((rs.getString(2)));
				r.setAccbal((rs.getDouble(3)));
				r.setUname((rs.getString(4)));
				r.setPass((rs.getString(5)));
				lst=new LinkedList<Register>();
				lst.add(r);			
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lst;
	}
	public int UpdateAccount(int accno,double accbal)
	{
		int i=0;
		List<Register> lst=null;
		con=m.getConnection();
		try {
			pstate=con.prepareStatement("update accountinfo set accbal=? where accno=?");
			pstate.setDouble(1,accbal);
			pstate.setInt(2,accno);
			i=pstate.executeUpdate();
			
			if(i>0)
			{
				return i;
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public int DeleteAccount(int accno)
	{
		int i=0;
		con=m.getConnection();
		try {
			pstate=con.prepareStatement("delete from accountinfo where accno=?");
			pstate.setInt(1,accno);
			i=pstate.executeUpdate();
			if(i>0)
			{
				return i;
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return i;
	}
}