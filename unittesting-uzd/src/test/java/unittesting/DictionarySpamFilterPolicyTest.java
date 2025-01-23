package unittesting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DictionarySpamFilterPolicyTest {
    @Test
    public void testConstructorWithNull() {
            try {
                DictionarySpamFilterPolicy dictionarySpamFilterPolicy = new DictionarySpamFilterPolicy(null);
                fail("Expected NullPointerException to be thrown");
            } catch (NullPointerException e) {
            }
        }

        @Test
    public void testSpamArgumentWithNull() {
        DictionarySpamFilterPolicy dictionarySpamFilterPolicy = new DictionarySpamFilterPolicy(new ArrayList<>());

        assertFalse("Should return false if an argument is null",dictionarySpamFilterPolicy.isSpam(null));
        }
        @Test
        public void testSpamDetectionWithNullSubject() {
            List<String> spamWords = Arrays.asList("spam");
            SpamFilterPolicy spamFilterPolicy = new DictionarySpamFilterPolicy(spamWords);

            Message messageSpam = new Message(null,"spam");
            Message messageNoSpam = new Message(null,"nice");

            assertTrue("Should detect spam in the text if subject is null", spamFilterPolicy.isSpam(messageSpam));
            assertFalse("Should not detect spam in the text if subject is null", spamFilterPolicy.isSpam(messageNoSpam));

        }
        @Test
    public void  testSpamDetectionWithNullText() {
        List<String> spamWords = Arrays.asList("spam");
        SpamFilterPolicy spamFilterPolicy = new DictionarySpamFilterPolicy(spamWords);

        Message messageSpam = new Message("spam",null);
        Message messageNoSpam = new Message("nice", null);

        assertTrue("Should detect spam in subject if text is null", spamFilterPolicy.isSpam(messageSpam));
        assertFalse("Should not detect spam in subject if text in null", spamFilterPolicy.isSpam(messageNoSpam));
        }
    @Test
    public void testSpamDetectionCaseSensitivity() {
        List<String> spamWordsLowercase = Arrays.asList("spam");
        List<String> spamWordsUppercase = Arrays.asList("SPAM");
        List<String> spamWordsRandomCapitalization = Arrays.asList("sPaM");

        SpamFilterPolicy spamFilterPolicyLower = new DictionarySpamFilterPolicy(spamWordsLowercase);
        SpamFilterPolicy spamFilterPolicyUpper = new DictionarySpamFilterPolicy(spamWordsUppercase);
        SpamFilterPolicy spamFilterPolicyRandomCapitalization = new DictionarySpamFilterPolicy(spamWordsRandomCapitalization);

        Message messageLowercase = new Message("spam","spam");
        Message messageUppercase = new Message("SPAM","SPAM");
        Message messageRandomCapitalization = new Message("SpAm","SpAm");
        Message messageMatchingCapitalization = new Message("sPaM","sPaM");

        assertFalse("Should not detect spam if all caps", spamFilterPolicyLower.isSpam(messageUppercase));
        assertFalse("Should not detect spam if all letters are not capitalized", spamFilterPolicyUpper.isSpam(messageLowercase));
        assertFalse("Should not detect spam if the capitalization does not match", spamFilterPolicyRandomCapitalization.isSpam(messageRandomCapitalization));
        assertTrue("Should match if the letters are lowercase", spamFilterPolicyLower.isSpam(messageLowercase));
        assertTrue("Should match if all the letters are uppercase", spamFilterPolicyUpper.isSpam(messageUppercase));
        assertTrue("Should match if the capitalization matches", spamFilterPolicyRandomCapitalization.isSpam(messageMatchingCapitalization));
    }
}
