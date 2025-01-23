package unittesting;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class SpamFilterTest {
    private SpamFilterPolicy spamFilterPolicy;

    @Before
    public void setUp() {
        spamFilterPolicy = new DictionarySpamFilterPolicy(new ArrayList<>());
    }

    @Test
    public void testConstructorWithNull() {
        try {
            SpamFilter sf = new SpamFilter(null);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testFilterNull() {
        List<Message> messages = null;
        SpamFilter sf = new SpamFilter(spamFilterPolicy);
        List<Message> filtered = sf.filter(messages);
        assertNotNull("Filtered list should not be null", filtered);
        assertTrue("Filtered list should be empty", filtered.isEmpty());
    }

    @Test
    public void testFilterEmpty() {
        List<Message> messages = new ArrayList<>();
        SpamFilter sf = new SpamFilter(spamFilterPolicy);
        List<Message> filtered = sf.filter(messages);
        assertNotNull("Filtered list should not be null", filtered);
        assertTrue("Filtered list should be empty", filtered.isEmpty());
        assertNotSame("Should return a new empty arraylist",messages,filtered);
    }
    @Test
    public void testAllMessagesAreSpam() {
        SpamFilterPolicy alwaysSpamPolicy = new SpamFilterPolicy() {
            @Override
            public boolean isSpam(Message message) {
                return true;
            }
        };

        List<Message> messages = Arrays.asList(
                new Message("Subject1", "Text1"),
                new Message("Subject2", "Text2"),
                new Message("Subject3", "Text3")
        );
        SpamFilter spamFilter = new SpamFilter(alwaysSpamPolicy);
        List<Message> filtered = spamFilter.filter(messages);
        assertEquals("When all messages are spam, filtered list should be same as input",
                messages, filtered);
        assertNotSame("A new list should be returned", messages, filtered);
    }
    @Test
    public void testNoMessagesAreSpam() {
        SpamFilterPolicy noSpamPolicy = new SpamFilterPolicy() {
            @Override
            public boolean isSpam(Message message) {
                return false;
            }
        };
        List<Message> messages = Arrays.asList(
                new Message("Subject1", "Text1"),
                new Message("Subject2", "Text2"),
                new Message("Subject3", "Text3")
        );
        SpamFilter spamFilter = new SpamFilter(noSpamPolicy);
        List<Message> filtered = spamFilter.filter(messages);
        assertEquals("When no messages are spam, filtered list should be empty", new ArrayList<>(), filtered);
        assertNotSame("A new list should be returned", messages,filtered);
    }

    @Test
    public void testSomeSpamMessages() {
        SpamFilterPolicy selectiveSpamPolicy = new SpamFilterPolicy() {
            @Override
            public boolean isSpam(Message message) {
                return message.getSubject().contains("spam");
            }
            };
            List<Message> messages = Arrays.asList(new Message("spam","text"),
                    new Message("spam2","text2"),
                    new Message("nice","text3")
            );
            SpamFilter spamFilter = new SpamFilter(selectiveSpamPolicy);
            List<Message> filtered = spamFilter.filter(messages);
            assertEquals("Should return only two messages", 2,filtered.size());
            assertTrue("Filtered messages should contain spam" ,
                    filtered.stream().allMatch(msg -> msg.getSubject().contains("spam")));
            assertFalse("Filtered messages should not contain non-spam messages",
                    filtered.stream().noneMatch(msg -> msg.getSubject().contains("spam")));

        }
    }


