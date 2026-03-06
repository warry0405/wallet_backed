package service;

import exception.BankAccountNotExsists;
import exception.BankAlreadyAdded;
import exception.NotAnyBankAddedYet;
import exception.UserNotLogedinException;
import model.BankCount;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BankCountRepository;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BankCountServiceImpl implements BankCountService {
    @Autowired
    private BankCountRepository bankCountRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public BankCount addBank(BankCount bankCount, Integer userid) throws UserNotLogedinException, BankAlreadyAdded {
        Optional<User> user = userRepository.findById(userid);
        if (user.isEmpty()) {
            throw new UserNotLogedinException("用户未登录或不存在");
        }
        List<BankCount> bankList = bankCountRepository.findAllByUserUserId(userid);
        for (BankCount b : bankList) {
            if (b.getAccountNumber().equals(bankCount.getAccountNumber())) {
                throw new BankAlreadyAdded(
                        "银行卡账户 " + bankCount.getAccountNumber() + " 已绑定");
            }
        }
        bankCount.setUser(user.get());
        bankCountRepository.save(bankCount);
        return bankCount;
    }

    @Override
    public BankCount removeBank(BankCount bankCount, Integer userid) throws UserNotLogedinException, BankAlreadyAdded {
        Optional<User> user = userRepository.findById(userid);
        if (user.isEmpty()) {
            throw new UserNotLogedinException("用户未登录或不存在");
        }

        List<BankCount> bankList = bankCountRepository.findAllByUserUserId(userid);

        BankCount target = null;
        for (BankCount b : bankList) {
            if (b.getAccountNumber().equals(bankCount.getAccountNumber())) {
                target = b;
                break;
            }
        }

        if (target == null) {
            throw new BankAlreadyAdded(
                    "银行卡账户 " + bankCount.getAccountNumber() + " 不存在或不属于该用户");
        }

        bankCountRepository.delete(target);

        return target;
    }

    @Override
    public BankCount viewBankCount(BankCount bankCount, Integer userid) throws BankAccountNotExsists, UserNotLogedinException {
        Optional<User> user = userRepository.findById(userid);
        if (user.isEmpty()) {
            throw new UserNotLogedinException("用户未登录或不存在");
        }

        Optional<BankCount> bankCount1 = bankCountRepository.findByCountNumber(bankCount.getAccountNumber());
        if (bankCount1.isEmpty()) {
            throw new BankAccountNotExsists("银行账户不存在");
        }
        return bankCount1.get();
    }

    @Override
    public List<BankCount> viewAllCount(Integer userid) throws UserNotLogedinException, NotAnyBankAddedYet, BankAccountNotExsists {
        Optional<User> user = userRepository.findById(userid);
        if (user.isEmpty()) {
            throw new UserNotLogedinException("用户未登录或不存在");
        }
        List<BankCount> bankList = bankCountRepository.findAllByUserUserId(userid);
        if (bankList.isEmpty()) {
            throw new BankAccountNotExsists("用户还没有银行账户");
        }
        return bankList;
    }
}
