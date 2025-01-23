package unittesting;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class SpamFilter {

    private final SpamFilterPolicy spamFilterPolicy;

    public SpamFilter(SpamFilterPolicy spamFilterPolicy) {
        this.spamFilterPolicy = Objects.requireNonNull(spamFilterPolicy);
    }

    /**
     * Accepts a list of messages and returns a list of spam messages.
     *
     * @param messages list of messages
     * @return list of messages that are spam.
     */
    public List<Message> filter(List<Message> messages) {
        if (messages == null || messages.isEmpty()) {
            return Collections.emptyList();
        }

        List<Message> spam = new LinkedList<>();

        for (Message message : messages) {
            if (spamFilterPolicy.isSpam(message)) {
                spam.add(message);
            }
        }

        return spam;
    }

}
