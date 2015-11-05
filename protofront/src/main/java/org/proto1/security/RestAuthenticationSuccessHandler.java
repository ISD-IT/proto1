/*******************************************************************************
 * Copyright (C) 2015  Valentin Pogrebinsky
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *******************************************************************************/
package org.proto1.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
 
/**
 * This will call once the request is authenticated. If it is not, the request
 * will be redirected to authenticate entry point
 * 
 * @author malalanayake
 * 
 */
@Component
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private RequestCache requestCache = new HttpSessionRequestCache();
 
    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request,
            final HttpServletResponse response, final Authentication authentication)
            throws ServletException, IOException {
        final SavedRequest savedRequest = requestCache.getRequest(request, response);
 
        if (savedRequest == null) {
            clearAuthenticationAttributes(request);
            return;
        }
        final String targetUrlParameter = getTargetUrlParameter();
        if (isAlwaysUseDefaultTargetUrl()
                || (targetUrlParameter != null && StringUtils.hasText(request
                        .getParameter(targetUrlParameter)))) {
            requestCache.removeRequest(request, response);
            clearAuthenticationAttributes(request);
            return;
        }
 
        clearAuthenticationAttributes(request);
 
        // Use the DefaultSavedRequest URL
        // final String targetUrl = savedRequest.getRedirectUrl();
        // logger.debug("Redirecting to DefaultSavedRequest Url: " + targetUrl);
        // getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }
 
    public void setRequestCache(final RequestCache requestCache) {
        this.requestCache = requestCache;
    }
}