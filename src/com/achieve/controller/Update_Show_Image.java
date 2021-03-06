package com.achieve.controller;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.achieve.model.AchieveService;
import com.achieve.model.AchieveVO;


//@WebServlet("/Update_Show_Image")
public class Update_Show_Image extends HttpServlet {
	public Update_Show_Image() {

	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("image/*");
		ServletOutputStream out = res.getOutputStream();
		String action = req.getParameter("action");
		
		if ("ach_Picture".equals(action)) {
			String ach_No = req.getParameter("ach_No");
			AchieveService achieveSvc = new AchieveService();
			try {
				AchieveVO achieveVO = achieveSvc.getOneAchieve(ach_No);
				InputStream in = new ByteArrayInputStream(achieveVO.getAch_Picture());
				byte[] buffer = new byte[in.available()];
				int len = 0;
				try {
					while ((len = in.read(buffer)) != -1)
						out.write(buffer, 0, len);
					out.close();
					return;
				} catch (IOException e) {
					e.printStackTrace();

				}
			} catch (Exception e) {
				FileInputStream in = new FileInputStream(getServletContext().getRealPath("/images/pot.png"));
				byte[] propic = new byte[in.available()];
				in.read(propic);
				out.write(propic);
				in.close();

			}

		}
	}

	
}

