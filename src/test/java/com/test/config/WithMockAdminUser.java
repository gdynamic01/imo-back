/**
 * 
 */
package com.test.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.security.test.context.support.WithMockUser;

/**
 * @author mbalde
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@WithMockUser(username="admin@yahoo.fr", roles = {"ADMIN", "USER_MORAL", "USER_PHYSIQUE"})
public @interface WithMockAdminUser {
}
