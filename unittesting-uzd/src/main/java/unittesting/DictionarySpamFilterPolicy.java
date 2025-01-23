package unittesting;

import java.util.List;
import java.util.Objects;

public class DictionarySpamFilterPolicy implements SpamFilterPolicy {

    private final List<String> spamWords;

    public DictionarySpamFilterPolicy(List<String> spamWords) {
        this.spamWords = Objects.requireNonNull(spamWords);
    }

    /**
     * Checks message subject and text for spam words from a dictionary.
     *
     * @param message message
     * @return true - if message is a spam, otherwise - false.
     */
    @Override
    public boolean isSpam(Message message) {
        if (message == null) {
            return false;
        }

        for (String spamWord: spamWords) {
            String subject = message.getSubject();
            String text = message.getText();

            if ((subject != null && subject.contains(spamWord)) || (text != null && text.contains(spamWord))) {
                return true;
            }
        }

        return false;
    }
}
