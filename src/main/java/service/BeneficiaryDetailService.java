package service;

import exception.BankAccountNotExsists;
import exception.BeneficiaryDetailException;
import exception.NotAnyBankAddedYet;
import exception.UserNotLogedinException;
import model.BeneficiaryDetail;

import java.util.List;
import java.util.Optional;

public interface BeneficiaryDetailService {
    public Optional<BeneficiaryDetail> addBeneficiaryDetail(String walletNo,String userNo) throws BeneficiaryDetailException,UserNotLogedinException;
    public Optional<BeneficiaryDetail> removeBeneficiaryDetail(String walletNo,String userNo) throws BeneficiaryDetailException,UserNotLogedinException;
    public List<BeneficiaryDetail> viewBeneficiaryDetail(String walletNo ) throws BeneficiaryDetailException, UserNotLogedinException;
    public List<BeneficiaryDetail> viewAllBeneficiaryDetail(String userNo) throws UserNotLogedinException,BeneficiaryDetailException;
}
