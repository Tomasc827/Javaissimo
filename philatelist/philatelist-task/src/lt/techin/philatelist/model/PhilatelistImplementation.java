package lt.techin.philatelist.model;

import lt.techin.philatelist.Philatelist;
import lt.techin.philatelist.PostStamp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PhilatelistImplementation implements Philatelist {
    private List<PostStamp> stamps;

    public PhilatelistImplementation() {
        this.stamps = new ArrayList<>();
    }

    @Override
    public void addToCollection(PostStamp postStamp) {
        if (postStamp == null || postStamp.getName() == null || postStamp.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (!this.stamps.contains(postStamp)) {
            stamps.add(postStamp);
        }
    }

    @Override
    public int getNumberOfPostStampsInCollection() {
        return this.stamps.size();
    }

    @Override
    public void printAllPostStampNames() {
        for (PostStamp one : stamps) {
            System.out.println(one.getName());
        }
    }

    @Override
    public void printPostStampsWithPriceGreaterThan(double v) {
        for (PostStamp postStamp : stamps) {
            if (postStamp.getMarketPrice() > v) {
                System.out.println(postStamp.getName());
            }
        }
    }

    @Override
    public boolean isPostStampInCollection(PostStamp postStamp) {
        return stamps.contains(postStamp);

    }

    @Override
    public boolean isPostStampWithNameInCollection(String s) {
        for (PostStamp one : stamps) {
            if (one.getName().equals(s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double calculateTotalMarketPrice() {
        double totalPrice = 0;
        for (PostStamp one : stamps) {
            totalPrice += one.getMarketPrice();
        }
        return totalPrice;
    }

    @Override
    public double getAveragePostStampPrice() {
        double totalPrice = 0;
        for (PostStamp one : stamps) {
            totalPrice += one.getMarketPrice();
        }
        return totalPrice / stamps.size();
    }

    @Override
    public PostStamp getTheMostExpensivePostStampByMarketValue() {
        double mostExpensive = 0;
        PostStamp mostExpensiveStamp = null;
        for (PostStamp one : stamps) {
            if (one.getMarketPrice() > mostExpensive) {
                mostExpensive = one.getMarketPrice();
                mostExpensiveStamp = one;
            }
        }
        return mostExpensiveStamp;
    }

    @Override
    public List<PostStamp> findPostStampsByNameContaining(String s) {
        List<PostStamp> result = new ArrayList<>();
        for (PostStamp one : stamps) {
            if (one.getName().contains(s)) {
                result.add(one);
            }
        }
        return result;
    }


    @Override
    public List<PostStamp> getSortedPostStampsByName() {
        List<PostStamp> sortedStamps = new ArrayList<>(stamps);
        Collections.sort(sortedStamps, new Comparator<PostStamp>()

        {
            @Override
            public int compare(PostStamp o1, PostStamp o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return sortedStamps;
    }
}