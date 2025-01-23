package unittesting;

public interface SpamFilterPolicy {

    /**
     * Checks whether a given message is a spam.
     *
     * @param message message
     * @return true - if message is spam, otherwise - false.
     */
    boolean isSpam(Message message);

}
