package service;

import exception.BeneficiaryDetailException;
import exception.NotAnyBankAddedYet;
import exception.UserNotLogedinException;
import model.BeneficiaryDetail;
import model.User;
import model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BeneficiaryDetailRepository;
import repository.UserRepository;
import repository.WalletRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiaryDetailServiceImpl implements BeneficiaryDetailService{
    @Autowired
    private BeneficiaryDetailRepository beneficiaryDetailRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WalletRepository walletRepository;

    //这个userId是用来确认要寻找的用户是否存在的
    @Override
    public Optional<BeneficiaryDetail> addBeneficiaryDetail(
            String walletNo, String userNo)
            throws BeneficiaryDetailException, UserNotLogedinException {

        // 1. 校验用户是否存在
        Optional<User> ownerOpt = userRepository.findByUserNo(userNo);
        if (ownerOpt.isEmpty()) {
            throw new UserNotLogedinException("用户不存在");
        }
        User owner = ownerOpt.get();

        // 2. 查找该用户的钱包（关键：从多的一端查）
        Optional<Wallet> walletOpt = walletRepository.findByWalletNo(walletNo);
        if (walletOpt.isEmpty()) {
            throw new BeneficiaryDetailException("该用户没有钱包");
        }
        Wallet wallet = walletOpt.get();

        BeneficiaryDetail beneficiaryDetail = new BeneficiaryDetail();
        beneficiaryDetail.setWallet(wallet);
        beneficiaryDetail.setName(owner.getUserName());
        beneficiaryDetail.setMobileNo(owner.getMobileNo());

        wallet.getBeneficiaryDetails().add(beneficiaryDetail);

        // 5. 保存
        BeneficiaryDetail saved = beneficiaryDetailRepository.save(beneficiaryDetail);
        return Optional.of(saved);
    }




    //这个userId是用来判断登录着的用户
    @Override
    public Optional<BeneficiaryDetail> removeBeneficiaryDetail(String walletNo,String userNo) throws BeneficiaryDetailException, UserNotLogedinException {

    };

    @Override
    public List<BeneficiaryDetail> viewBeneficiaryDetail(String walletNo) throws BeneficiaryDetailException, UserNotLogedinException {

    };

    @Override
    public List<BeneficiaryDetail> viewAllBeneficiaryDetail(String userNo) throws UserNotLogedinException,BeneficiaryDetailException{

    }
}
