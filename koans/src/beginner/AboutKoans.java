package beginner;

import com.sandwich.koan.Koan;

import static com.sandwich.util.Assert.fail;

public class AboutKoans {

    @Koan
    public void findAboutKoansFile() {
        // Hello, I'm a koan. I'm a piece of code, piece of wisdom,
        // which you learn JAVA with. Every koan is a small task to solve.
        // To solve it is to make it pass, or not to fail.
    }

    @Koan
    public void definitionOfKoanCompletion() {
        boolean koanIsComplete = true;
        if (!koanIsComplete) {
            fail("what if koanIsComplete variable was true?");
        }
    }

}
