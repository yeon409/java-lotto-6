package lotto;

import static lotto.Lotto.LOTTO_END_NUMBER;
import static lotto.Lotto.LOTTO_NUMBER_SIZE;
import static lotto.Lotto.LOTTO_START_NUMBER;
import static lotto.LottoGameReader.getMoneyFromConsole;
import static lotto.message.LottoGameAnnouncement.COUNT_OF_LOTTO;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.util.VisibleForTesting;

public class LottoGame {

    public static void start() {
        LottoMoney money = getMoneyFromConsole();
        List<Lotto> lottoNumbers = getLottoNumbers(money.getCountForBuyingLotto());
    }

    private static List<Lotto> getLottoNumbers(int countForBuyingLotto) {
        System.out.println(countForBuyingLotto + COUNT_OF_LOTTO.getMessage());
        List<Lotto> lottoNumbers = generateLottoNumbersByRandom(countForBuyingLotto);
        printLottoNumbers(lottoNumbers);
        return lottoNumbers;
    }

    @VisibleForTesting
    protected static List<Lotto> generateLottoNumbersByRandom(int count) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        while(count-- > 0) {
            List<Integer> numbers =
                    Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_SIZE);
            Lotto lottoNumber = new Lotto(numbers);
            lottoNumbers.add(lottoNumber);
        }
        return lottoNumbers;
    }

    private static void printLottoNumbers(List<Lotto> lottoNumbers) {
        for (Lotto lotto : lottoNumbers) {
            System.out.println(lotto.getLottoNumbersAsFormat());
        }
    }
}
