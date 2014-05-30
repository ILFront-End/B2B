package com.sanyinchen.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sanyinchen.Contendata.ContentData;
import com.socket.content.Contentdata;

public class upload extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public upload() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String fileName = null;// �ϴ��ļ���
		// ����Fileupload��������ϴ�
		DiskFileItemFactory factory = new DiskFileItemFactory();// ��������

		// �����ϴ�·��Ϊ��Ŀ��upload�ļ���
		String path = request.getContextPath();
		path = request.getRealPath(path);

		int i = path.lastIndexOf("\\");
		path = path.substring(0, i + 1);
		path = path + "\\upload";
		File fl = new File(path);
		if (!fl.exists()) {
			fl.mkdirs();// ����ļ���upload�������򴴽���
		}
		factory.setRepository(fl);
		ServletFileUpload upload = new ServletFileUpload(factory);

		try {
			List<FileItem> list = upload.parseRequest(request);// ��ȡ�ϴ�������
			for (FileItem item : list) {
				if (!item.isFormField())// ���������
				{
					// ������ļ���д�����
					String name = item.getFieldName();

					String value = item.getName();

					// ��ȡ�ļ�����ȡ���һ��\�ź����ԭ�ļ���
					int start = value.lastIndexOf("\\");
					fileName = value.substring(start + 1);
					String[] temp = fileName.split("\\.");
					fileName = temp[0] + "_" + System.currentTimeMillis() + "."
							+ temp[1];
					System.out.println("===================" + fileName);
					System.out.println("===================" + temp.length);
					System.out.println("===================" + temp[0]);
					System.out.println("===================" + temp[1]);
					// ���ļ�д�����
					item.write(new File(path, fileName));
				}
			}
			String pathq = ContentData.IP_path + "/upload/" + fileName;
			out.println(pathq);
			System.out.println("�ϴ�Success:" + pathq);

		} catch (Exception e) {
			out.println("error");
			e.printStackTrace();
		}

		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
