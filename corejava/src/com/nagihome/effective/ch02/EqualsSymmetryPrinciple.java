package com.nagihome.effective.ch02;

public class EqualsSymmetryPrinciple {

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("s");
        System.out.println("Un Symmetric: cis.equals(\"s\"): " + cis.equals("s")
                + "; \"s\".equals(cis): " + "s".equals(cis));
    }

    static class CaseInsensitiveString {
        private final String s;

        public CaseInsensitiveString(String i) {
            if (i == null)
                throw new NullPointerException();
            this.s = i;
        }

        @Override
        public boolean equals(Object o) {
            return ((o instanceof CaseInsensitiveString) && (s.equals((String) o)));
        }
    }
}
