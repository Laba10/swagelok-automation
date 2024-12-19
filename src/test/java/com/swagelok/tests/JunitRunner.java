package com.swagelok.tests;

import com.swagelok.tests.suites.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)

@Suite.SuiteClasses({
        LoginSuite.class,
        NegativeLoginSuite.class,
        QuickOrderSuite.class,
        NegativeQuickOrderSuite.class,
        CartSuite.class,
        SearchSuite.class
//        RegistrationSuite.class
})

public class JunitRunner {
}
