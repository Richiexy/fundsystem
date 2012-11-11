/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.chenjun.struts.action;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.chenjun.fund.model.LoginStatus;
import com.chenjun.service.AccountService;
import com.chenjun.service.impl.AccountServiceImpl;
import com.chenjun.struts.form.LoginForm;
import com.chenjun.utils.compress.Compress;
import com.google.gson.Gson;

/** 
 * MyEclipse Struts
 * Creation date: 05-03-2012
 * 
 * XDoclet definition:
 * @struts.action path="/login" name="loginForm" input="/loginTestJsp.jsp" scope="request" validate="true"
 */
public class LoginAction extends Action {
	
	AccountService accountService = new AccountServiceImpl();
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LoginForm loginForm = (LoginForm) form;
		
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		
		LoginStatus status = accountService.login(username, password);
		
		String jsonStr = new Gson().toJson(status, LoginStatus.class);
		
		byte[] resultOriginalByte = jsonStr.getBytes();
		ByteArrayOutputStream resultBuffer = new ByteArrayOutputStream();
		OutputStream os = null;
		
		try {
			
			os = response.getOutputStream();
			//如果要返回的结果字节数组小于50位，不将压缩
			if(resultOriginalByte.length < Compress.BYTE_MIN_LENGTH){
				byte flagByte = Compress.FLAG_GBK_STRING_UNCOMPRESSED_BYTEARRAY;
				resultBuffer.write(flagByte);
				resultBuffer.write(resultOriginalByte);
			}
			else{
				byte flagByte = Compress.FLAG_GBK_STRING_COMPRESSED_BYTEARRAY;
				resultBuffer.write(flagByte);
				resultBuffer.write(Compress.byteCompress(resultOriginalByte));
			}
			resultBuffer.flush();
			resultBuffer.close();
			os.write(resultBuffer.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
		
	}
}