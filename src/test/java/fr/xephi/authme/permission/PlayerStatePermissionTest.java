package fr.xephi.authme.permission;

import org.junit.Test;

import java.util.Collection;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;
import static org.junit.Assert.fail;

/**
 * Test for {@link PlayerStatePermission}.
 */
public class PlayerStatePermissionTest extends AbstractPermissionsEnumTest {

    @Test
    public void shouldNotStartWithOtherPrefixes() {
        // given
        Set<String> forbiddenPrefixes = newHashSet("authme.player", "authme.admin", "authme.debug");

        // when/then
        for (PlayerStatePermission permission : PlayerStatePermission.values()) {
            if (startsWithAny(permission.getNode(), forbiddenPrefixes)) {
                fail("The permission '" + permission + "' should not start with any of " + forbiddenPrefixes);
            }
        }
    }

    @Override
    protected PermissionNode[] getPermissionNodes() {
        return PlayerStatePermission.values();
    }

    @Override
    protected String getRequiredPrefix() {
        return "authme.";
    }

    private static boolean startsWithAny(String node, Collection<String> prefixes) {
        for (String prefix : prefixes) {
            if (node.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }
}
