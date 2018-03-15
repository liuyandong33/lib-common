package build.dream.common.configuartions;

import build.dream.common.constants.Constants;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by liuyandong on 2017/4/3.
 */
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUserDetails customUserDetails = new CustomUserDetails(1, username, Constants.SECURITY_DEFAULT_PASSWORD, null, true, true, true, true);
        return customUserDetails;
    }
}
