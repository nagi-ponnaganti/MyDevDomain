package com.nagihome.beghib.ch06;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ISBN implements Serializable {
    private int groupName;
    private int publisher;
    private int title;
    private int checkdigit;

    public ISBN() {
    }

    public int getGroupName() {
        return groupName;
    }

    public void setGroupName(int groupName) {
        this.groupName = groupName;
    }

    public int getPublisher() {
        return publisher;
    }

    public void setPublisher(int publisher) {
        this.publisher = publisher;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getCheckdigit() {
        return checkdigit;
    }

    public void setCheckdigit(int checkdigit) {
        this.checkdigit = checkdigit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ISBN)) return false;

        ISBN isbn = (ISBN) o;

        if (checkdigit != isbn.checkdigit) return false;
        if (groupName != isbn.groupName) return false;
        if (publisher != isbn.publisher) return false;
        if (title != isbn.title) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupName;
        result = 31 * result + publisher;
        result = 31 * result + title;
        result = 31 * result + checkdigit;
        return result;
    }
}
