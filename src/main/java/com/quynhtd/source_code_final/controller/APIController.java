package com.quynhtd.source_code_final.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class APIController {

	@GetMapping("/profile")
	public String getProfile() {
		return "profile";
	}
	
	@GetMapping("/alerts_tooltips")
	public String getalerts_tooltips() {
		return "alerts_tooltips";
	}
	
	@GetMapping("/forgot_password")
	public String getForgot_password() {
		return "forgot_password";
	}
	
	@GetMapping("/datatables")
	public String getDatatables() {
		return "datatables";
	}
	
	@GetMapping("/lists")
	public String getlists() {
		return "lists";
	}
	
	@GetMapping("/typography")
	public String getTypography() {
		return "typography";
	}
	
	@GetMapping("/badges_progress")
	public String getBadges_progress() {
		return "badges_progress";
	}
	
	@GetMapping("/buttons")
	public String getButtons() {
		return "buttons";
	}
	
	@GetMapping("/calendar")
	public String getCalendar() {
		return "calendar";
	}
	
	@GetMapping("/cards")
	public String getCards() {
		return "cards";
	}
	
	@GetMapping("/chartjs")
	public String getChartjs() {
		return "chartjs";
	}

	@GetMapping("/charts_flot")
	public String getCharts_flot() {
		return "charts_flot";
	}

	@GetMapping("/charts_morris")
	public String getCharts_morris() {
		return "charts_morris";
	}

	@GetMapping("/charts_sparkline")
	public String getCharts_sparkline() {
		return "charts_sparkline";
	}

	@GetMapping("/colors")
	public String getColors() {
		return "colors";
	}

	@GetMapping("/form_basic")
	public String getForm_basic() {
		return "form_basic";
	}

	@GetMapping("/icons")
	public String getIcons() {
		return "icons";
	}
	
	
	@GetMapping("/form_advanced")
	public String getForm_advanced() {
		return "form_advanced";
	}
	

	
	
	
	
}
