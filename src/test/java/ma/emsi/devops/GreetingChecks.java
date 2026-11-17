package ma.emsi.devops;

public final class GreetingChecks {
    private GreetingChecks() {}

    public static void main(String[] args) {
        check("sans argument", "Bonjour, DevOps EMSI !", Main.greeting(null));
        check("argument vide", "Bonjour, DevOps EMSI !", Main.greeting("   "));
        check("argument personnalisé", "Bonjour, EMSI !", Main.greeting(" EMSI "));
    }

    private static void check(String test, String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError(test + ": attendu [" + expected + "], obtenu [" + actual + "]");
        }
        System.out.println("OK - " + test);
    }
}
