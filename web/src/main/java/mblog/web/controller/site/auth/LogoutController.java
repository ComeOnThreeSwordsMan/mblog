/*
+--------------------------------------------------------------------------
|   Mblog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 mtons. All Rights Reserved
|   http://www.mtons.com
|
+---------------------------------------------------------------------------
*/
package mblog.web.controller.site.auth;

import mblog.web.controller.BaseController;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @author an
 *
 */
@Controller
public class LogoutController extends BaseController {

	@RequestMapping("/logout")
	public String logout(HttpServletResponse response) {
		SecurityUtils.getSubject().logout();
		// HTTP 1.1.
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		// HTTP 1.0.
		response.setHeader("Pragma", "no-cache");
		// Proxies.
		response.setDateHeader("Expires", 0);
		return "redirect:/index";
	}

}
