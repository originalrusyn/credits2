package com.m;

import com.google.appengine.api.NamespaceManager;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class NamespaceFilter extends GenericFilterBean {

    private static final String NAMESPACE = "m";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (NamespaceManager.get() == null) {
            NamespaceManager.set(NAMESPACE);
        }
        chain.doFilter(request, response);
    }
}
