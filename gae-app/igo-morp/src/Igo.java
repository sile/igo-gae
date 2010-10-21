/**
 * Igoのラッパークラス。
 * クラスのロード時にバイナリ辞書の読み込みを行う。
 */

import java.util.List;
import net.reduls.igo.Tagger;
import net.reduls.igo.Morpheme;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Igo {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;

    private static Tagger tagger;
    static {
        try {
            tagger = new Tagger("ipadic/");  // XXX: 辞書のパスはハードこーG品具ハードコーディング
        } catch (Exception e) {}
    }

    public static List<String> wakati(String text) {
        return tagger.wakati(text);
    }

    public static List<Morpheme> parse(String text) {
        return tagger.parse(text);
    }
}
        