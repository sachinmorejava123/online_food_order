package com.nacre.ofo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;

@WebServlet("/ItemsImageRetrievalController")
public class ItemsImageRetrievalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletOutputStream out=null;
	Blob image=null;
	int len=0;
	byte [] img=null;
	InputStream readImg=null;
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		out = res.getOutputStream();
		
		String image1=req.getParameter("image");
		byte[] img1 =image1.getBytes();
		try {
			image = new SerialBlob(img1);
		/*res.setContentType("image/png");
		OutputStream o=res.getOutputStream();
		o.flush();
		o.write(img);
		o.close();*/		
			len = (int)image.length();		
			img = new byte[len];
			readImg = image.getBinaryStream();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int index=readImg.read(img, 0, len);
		readImg.close();
		res.resetBuffer();
		res.reset();
		out.write(img,0,len);
		out.flush();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
