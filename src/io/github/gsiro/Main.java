package io.github.gsiro;

import io.github.gsiro.package1.LegacyClass;

public class Main {
    public static void main(String[] args) {
        var legacyService = new LegacyClass();
        var apiUser = new ApiUser(legacyService);
        apiUser.run();
	// write your code here
    }
}
