package com.cjrequena.sample.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * <p>
 * <p>
 * <p>
 *
 * @author cjrequena
 */
@Controller
public class CustomErrorController implements ErrorController {

  private static final String PATH = "/error";

  @RequestMapping(value = "/error")
  public String renderError(Model model, HttpServletRequest httpRequest) {

    int httpErrorCode = getErrorCode(httpRequest);

    switch (httpErrorCode) {
      case 400: {
        return "/error/400";
      }
      case 401: {
        return "/error/401";
      }
      case 404: {
        return "/error/404";
      }
      case 500: {
        return "/error/500";
      }
      default:
        return "/error";
    }
  }

  @Override
  public String getErrorPath() {
    return PATH;
  }

  private int getErrorCode(HttpServletRequest httpRequest) {
    return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
  }
}
