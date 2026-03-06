package service;

import exception.BankAccountNotExsists;
import exception.BankAlreadyAdded;
import exception.NotAnyBankAddedYet;
import exception.UserNotLogedinException;
import model.BankCount;

import java.util.List;


public interface BankCountService {
    public BankCount addBank(BankCount bankCount, Integer userid) throws UserNotLogedinException, BankAlreadyAdded;

    public BankCount removeBank(BankCount bankCount, Integer userid) throws UserNotLogedinException, BankAlreadyAdded;

    public BankCount viewBankCount(BankCount bankCount, Integer userid) throws BankAccountNotExsists, UserNotLogedinException;

    public List<BankCount> viewAllCount(Integer userid) throws UserNotLogedinException, NotAnyBankAddedYet, BankAccountNotExsists;
}
