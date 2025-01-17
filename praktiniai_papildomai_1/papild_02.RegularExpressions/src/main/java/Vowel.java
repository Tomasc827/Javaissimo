public enum Vowel {
    A('a'),
    E('e'),
    I('i'),
    O('o'),
    U('u');

    private char vowel;

    Vowel(char vowel) {
        this.vowel = vowel;
    }

    public char getVowel() {
        return vowel;
    }
}
