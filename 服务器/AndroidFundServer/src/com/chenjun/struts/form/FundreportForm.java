/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.chenjun.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 03-28-2012
 * 
 * XDoclet definition:
 * @struts.form name="fundreportForm"
 */
public class FundreportForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** date property */
	private String date;

	/*
	 * Generated Methods
	 */

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}

	/** 
	 * Returns the date.
	 * @return String
	 */
	public String getDate() {
		return date;
	}

	/** 
	 * Set the date.
	 * @param date The date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
}