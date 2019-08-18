package HackerRank;

import sun.java2d.pipe.SpanShapeRenderer;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Shailendra on 2/18/2017.
 * this question came in COne.
 */
public class Solution {
    private static String DATE_STRING_FORMAT = "MM/dd/yyyy";
    private static String OFFER_START_DATE = "07/12/2014";

    public static void main(String[] args) throws ParseException {

        //Date date1= getDateFromString("01/12/2012");

        Account account1 = new Account("a", getDateFromString("01/12/2012"), 750.00, 1000.00);
        Account account2 = new Account("b", getDateFromString("01/12/2011"), 10000.00, 10000.00);
        Account account3 = new Account("c", getDateFromString("09/12/2011"), 1999.00, 4200.00);

        List<Account> accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        String[] arr=getAccountsInOrder(accounts);
        for(String name: arr) {
            System.out.println(name);
        }
    }

    private static Date getDateFromString(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_STRING_FORMAT, Locale.ENGLISH);
        return sdf.parse(date);
    }

    protected static String[] getAccountsInOrder(List<Account> accounts) throws ParseException {

        Calendar offerDate = Calendar.getInstance();
        offerDate.setTime(getDateFromString(OFFER_START_DATE));
        /*for (Account acc : accounts) {
            int age = 0;
            //Date accountOpenDate=acc.getAccountOpenDate();
            Calendar accountOpenDate = Calendar.getInstance();
            accountOpenDate.setTime(acc.getAccountOpenDate());
            age = (offerDate.get(Calendar.YEAR) - accountOpenDate.get(Calendar.YEAR)) * 12;
            age = age + (offerDate.get(Calendar.MONTH) - accountOpenDate.get(Calendar.MONTH));

            if (age > 24) {
                if ((acc.getAccountCurrentBalance() >= 0) && (acc.getAccountCurrentBalance() <= 10000)) {
                    if (acc.getAccountCreditLimit() >= 1000 && acc.getAccountCreditLimit() <= 10000) {
                        double score = age * ((acc.getAccountCreditLimit() - acc.getAccountCurrentBalance()) / acc.getAccountCreditLimit());
                        acc.setAccountScore(score);
                    }
                }
            }
        }*/
        accounts.forEach(acc-> {
            int age = 0;
            //Date accountOpenDate=acc.getAccountOpenDate();
            Calendar accountOpenDate = Calendar.getInstance();
            accountOpenDate.setTime(acc.getAccountOpenDate());
            age = (offerDate.get(Calendar.YEAR) - accountOpenDate.get(Calendar.YEAR)) * 12;
            age = age + (offerDate.get(Calendar.MONTH) - accountOpenDate.get(Calendar.MONTH));

            if (age > 24) {
                if ((acc.getAccountCurrentBalance() >= 0) && (acc.getAccountCurrentBalance() <= 10000)) {
                    if (acc.getAccountCreditLimit() >= 1000 && acc.getAccountCreditLimit() <= 10000) {
                        double score = age * ((acc.getAccountCreditLimit() - acc.getAccountCurrentBalance()) / acc.getAccountCreditLimit());
                        acc.setAccountScore(score);
                    }
                }
            }
        });
        Collections.sort(accounts, (Account a1, Account a2) -> {
            return a2.getAccountScore().compareTo(a1.getAccountScore());
        });

        List<String> list=new ArrayList<>();
        accounts.forEach(account->list.add(account.getName()));

        String[] arr=new String[list.size()];
        return list.toArray(arr);
    }
}

 class Account {
    private String name;
    private Date accountOpenDate;
    private Double accountCurrentBalance;
    private Double accountCreditLimit;
    private int ageInMonthsAtTimeOfOffer;
    private Double accountScore;

    protected Account(String name,Date accountOpenDate, Double accountCurrentBalance,Double accountCreditLimit)
        throws ParseException {
        this.name=name;
        this.accountOpenDate=accountOpenDate;
        this.accountCurrentBalance=accountCurrentBalance;
        this.accountCreditLimit=accountCreditLimit;
    }
     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public Date getAccountOpenDate() {
         return accountOpenDate;
     }

     public void setAccountOpenDate(Date accountOpenDate) {
         this.accountOpenDate = accountOpenDate;
     }

     public Double getAccountCurrentBalance() {
         return accountCurrentBalance;
     }

     public void setAccountCurrentBalance(Double accountCurrentBalance) {
         this.accountCurrentBalance = accountCurrentBalance;
     }

     public Double getAccountCreditLimit() {
         return accountCreditLimit;
     }

     public void setAccountCreditLimit(Double accountCreditLimit) {
         this.accountCreditLimit = accountCreditLimit;
     }

     public int getAgeInMonthsAtTimeOfOffer() {
         return ageInMonthsAtTimeOfOffer;
     }

     public void setAgeInMonthsAtTimeOfOffer(int ageInMonthsAtTimeOfOffer) {
         this.ageInMonthsAtTimeOfOffer = ageInMonthsAtTimeOfOffer;
     }

     public Double getAccountScore() {
         return accountScore;
     }

     public void setAccountScore(Double accountScore) {
         this.accountScore = accountScore;
     }
 }
