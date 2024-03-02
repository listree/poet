package com.meta;

import com.amazonaws.services.redshift.model.UsageLimit;

/**
 * https://leetcode.com/problems/split-message-based-on-limit/description/
 * 2468. Split Message Based on Limit Hard
 * You are given a string, message, and a positive integer, limit.
 * You must split message into one or more parts based on limit. Each resulting part should have the suffix "<a/b>",
 * where "b" is to be replaced with the total number of parts and "a" is to be replaced with the index of the part,
 * starting from 1 and going up to b. Additionally, the length of each resulting part (including its suffix)
 * should be equal to limit, except for the last part whose length can be at most limit.
 * The resulting parts should be formed such that when their suffixes are removed and they are all concatenated in order,
 * they should be equal to message. Also, the result should contain as few parts as possible.
 * Return the parts message would be split into as an array of strings.
 * If it is impossible to split message as required, return an empty array.
 * Constraints:
 * 1 <= message.length <= 10^4
 * message consists only of lowercase English letters and ' '.
 * 1 <= limit <= 10^4
 */
public class SplitMessage {

    public final static void main(String[] args) {

        SplitMessage splitMessage = new SplitMessage();

        String message1 = "this is really a very awesome message";
        // Output: ["thi<1/14>","s i<2/14>","s r<3/14>","eal<4/14>","ly <5/14>","a v<6/14>","ery<7/14>", " aw<8/14>","eso<9/14>",
        // "me<10/14>"," m<11/14>","es<12/14>","sa<13/14>","ge<14/14>"]
        String[] output1 = splitMessage.splitMessage(message1, 9);
        for(String string: output1) System.out.println(string);

        String message2 = "short message";
        // Output: ["short mess<1/2>","age<2/2>"]
        String[] output2 = splitMessage.splitMessage(message2, 15);
        for(String string: output2) System.out.println(string);

        String message3 = "boxpn";
        String[] output3 = splitMessage.splitMessage(message3, 5);
        for(String string: output3) System.out.println(string);

        String message4 = "lw gihuzqdojulow alnfyfadromuqpkrpleuifkrqwpalsnhphtsvffoybjzixqz xmelcofvtpowiazbhawiycobvsppzigwnuzxzgf xufkniabvemdlrbuxzyqswlkjxfmiiytnjzymcsbqfdnmvfsrklytokehzsnu  nndt nuyd ulz lzmwmskfrxhlrpambnxlamnbf ieihpqvqayruxtkatldicnhbuwfccjcnasmzyenwspcagwoencqxtvznhieqegdaebmmvydpmkcznerwtgvhvfhmonjimxlceupagzhbcgaworvvbxhuolzazdedntxzbpebkmi bg pxhnzogdcobrfvfmiohdlkcggxjiwdjuwzdmaogtxvwftdaogermkkqvfl pfpmoxeomzdameamdfuwoko tkyjktmtmqnyq qvns qudrkdkamss qmbznjdkhnmoxhkgliesrffkbjhlzsavgvrwnvjigaywertoaajegkkksgfz ntkwusorklyjmyxlzmebavfshpcbkiaxwtvzczwhqnsyihiahnpxwyvcnv debxiygmcyshmmm eaone ppwaqdtdlqmypcezoxwkgrnutaihadmsucpqfpjgrguyablwgedwccscwnghwb fimtqts fjxfjaffvgjyikktscjnekznwxtjkdydrofuec qsikuz xpv lbgwexrnyppydxzbwyviqponvpknezkqeqizqvkhjextgrmowa ilazvgox svnlsmzsubzipnclreokenhvgdpsapmygzrwnpsnpkaogjmb ufwyff tfctzvdhrcxzguhipvjqxmaiguzhgwtbjqb zhtkmodfieykqfrhsgexqjobkhnof kubtcs jobfyxo dtcuoerveantfrmodoqobrqizvhvmawvhdygebfopgmnyruvizzfdd foslqtzegqyiaozujsayysqdh covwluwfgrklyfb fydfjufpdigzpjeotnqwx  ppxcaxhogjpcetvt udzrlkblmztwjjdnppcaxaglfyqpoxudafzsmzziztgl kyrloumweizdvdkkhksijuepbbhwxllht pdcsedzarqzqebyypxdeqoerbperyxqinpwtwsfovyngvbdsgeancmniavasktilhpvdndnpgiprvvowdnnahyostezssu gwvnhmvbhjzxas rdnvb yaevyfgcgahlqmbfjgkawmaocvkhh gpnoyoejtdhwedh moxkjlhamfnygkdimpcrhxfvzsdavqvrmljelntxhwy gbkcfhwwnmnkylzqebsroxnvfsqgpoggrctroofjtzczgekgkhazbthmfjjaccvdooygxsqlrpfvshytyzlyhdjlrjoxopmsqthtujkwbkisyhubdvnjtoouyruralegwyurirueeyoicndqyyrrwjmbrhlsqewjhtylctkqygtj qxf oatsbaixjzlcxxmxsgthiumcnxuscjtvnxhbqhpfnqw qpomhydqvuabglvlhfly eazele pihszdyk xlvjusbjupfzqehycpxetpylncrrsxctg rhnnzadiubbfrcuqydgrzhjoepwjayjieydjbajeymordmwjcrelimwhocewlpaofzfw ktelrptcgslozditwbshuurknlk cacsoryhsmjzqpvopuexcftswsdcjfviroewqkdbngz trmcodmegnbwulil hckegiusjjgjrkrwnoudajtvbssjypwldjqkcvusiyirjlzhpocuurzmwcddhyqqpostpiswrzqxwcrgejlalqk xotersuqenfwxjlqprfuacoaolvatwxgfaozsmktafqxtjjgmqho nxpjchxzrefuxosswnxhajfdwubfnwwiinklwjxaerkyubdhtpni pv qxnitdbayilrsyvmstwrmxkavgmhsfnwoqynzqiwetwhparksqdgraoliy errhvniwrpgspwqbenahfgrjzbzgmpidrkddcjpdtdefvuvdvotepswwmmcawcgiqqgqwcwezmfczzwozgikpndjonqykfwagnnuykasmoxdrbnppfhyuhiulifkoqcvukeygrfusnrppvfygmxfrpkojqphjleoajylibtwsmdwgiykoflqkrtptglsmzwnutxwwmtybzylozolltbpebb esn fdvxubflxjjavctutmziwwsjgdn egfuyyiepzdowglbenuwjuyjmctdibsznfborzabrixiertqtmugozhl bjpzmhngjd m dvvactrwvlwbtnrjuoxgvqdoxypysrhkfwirztizsfhiqziys smgcnzbhrexaafazukexsgfmjgwhitgzyynxomao llgsewbcg wjkbftumqskjzfdvmlpxybrjzfeerr zumvtzpmbqbcjpmptfwtoosfsvwntndaikgzlssqwpwh fbtxtayqoycqymwfzwthqljvurunlmviilippdcypluhrptoqmuhqwqevoewpmsiivtvtaueczapzzcmuptpwqtapweqa amqaflmqjeosiiqaani  gwyoomxsrputxdoasyeymljeygfadkhu ifpjptcqsgxnfkkuirpfaw wluvnlmwru xkf klswqtpptuxdqxfc dv isqbimhdwfasyuresmqsjlnuidiivkwlvlkntqncsinimfjmmexrayw wcqkiftbxgkbyersmcnvsdhqdkrtjkqtyvdsebhjcelwxqkkojwjd xfljtfqwapd nbrrx kxywdhxcwdocosvckmlhrumhnqgfgyihhvinofqhjitxez zhjascmayjevaktsixyrcydce tutef icgwruzowypyybvmphautrhtfyznv eaqnhvfvgtwouquxpdgqimpqpykedznrcxfxbtfdudjlvboj qjcofikxkwaklchpkx ufmoqmv zgikwtdfuzkiir bvyedkegktigfyrnd amblquazcu gpheff akwvg oalxgdwlkub cvxqytwjdryuyesonewceszelfegpkdiabtvtanyzuzmmdbybqhymfvz qbfvblafswwpoopoqxipcdguigychsqcjchkeoxjcklifrw jxphdp judhysizktk niyqopyxefaniirxjkryixpvtuujcg jjnpdbzzyibbbadzwxyhmykzh mfpnuoaddbzlcmhhgrfqkgn jih axwgzhpld iybrsgxwadkhcenggyfqffcdsidi ye ryjxxlgujmdmwtakoyhknweico zytiunokeczyxtghclydmzwgihqnpxhtrqkuapecimfnzzghonvoxbiuvbwinfnptjsjammugebcqzv xopzeejapbszsfmlgtlpflsashtpvpqziqamcgwbqcrgwuuggvfsamlkpaxgpeggqbullvaekrmdvbmu guzmbktxhfmoileqgegfnifnaqcuhhzdibmfhxxerrwzrgvsvthaab wameargtuo lslvisfvkpzkdqyokbeulftj fwgsotumnzbwtcnhiojjqsz dmdam ofgylshz fdsmbqayxoanhz yepfeesqmzihhjyzfwpqfcfxgppzraazonaaovfpgpsxrdtqkreatuxelwgiaphuywnogutrojylwagpdqqhbvfqpfuqncvsmnvchk bmfchzkveikhaocsdqeceuggov bxlummfmdlgfulkaegdtbpltjgtawmjovpscajuxgxecwafqetk wqnlmglxfyixhet rjeeindllphsm bftpeiijpsonrnlidpxemloqrnenmzplxiccbxvttegumsobv vlfnyrxjqk ginzh sggzpkgjiochvvihjnizcgmm spciobyssvkhetwdnrfdxwbxvkmeeeuwtxbdp deinjwctn j wjrojigdgptttvkvlfotrnvrtrkofrcnynambtjoosibcoiyshafbmxpmdm xrlmqafpckrjsurmfyryzuxqnuexxhhfwzndsncbwiszlitlauwajxevyvgzjwncqdaywlftaopenbfsozavkbbrqc urlsetqoqrfsnqaepq lcwf wggmsenxgnoxbyoboemajwbauuquinunlrpsjzzxkarrpjujshqitycmigbobnujvadeteuxqnopbpj bhrdztq mh izomxhenxbmroawhckjbrtkzp tgcmcj snxbpj stcsoidxdohfdz ewwkcbfwjxwvmnjwvvyxhgsp nnnsdo msjxxxjgovqurfkeooyuqprum twzxfu z jtoibvrtytyrwnxjttzyrlbwwignicuowoxziypbq qrcbwracxkfdzpcqxhcabhzoegknvtytyaucnaombtodgnmgbswespagnqfsjbkfkiefnebkbsijqprfgwqpcilxtdroqabhonvnsjmmow xchzyyex lqyosnlregvraabbwyketnspjfvkpyuagtwdehvupkcjlwfslhrziitbcinmyxcyijqdbtkwu itxzvjipoaucaxsjtps cmfgwbsnlwakdxnxbwjwvyujldil mlvtwzmfyeophqwxsfqirahgpbahlkfaqdyrifzvahjcfhsjwhvzotkrdjcpbplzasguulktkiatvkwdevyzotydlpxwvtpfeh ghuddeafsmnkmulfzfgfsgymjjpvoymwgglc qpybjewomsdddhxrxhwxol xxheqepdssofyyoyqstebysqlcdpaczzegvvvpalrvdvuihtjyurkbziubzej lh wecfjvulj kfiajllrjad nrbwbzbhnesmxs dusukbrrqoohfitcszhbxeuioroagpgptacam r kqrksoapfqxqpmxswzbcuqrtsqrrmcunw gj duszyyzfpckmobyrisvlosbxaperclrkuzdalfvuowxcnbmbtcjvhpdfj cdi tylmrbwoefrxroxzwmzknaglmggioaxdamirjchsainnaveduorsbys sfixkz l fwxbgrsgrtr noelhcxcbzjxyeexlsnwlhfbjnvnastdprokqkmivervwrmtjbzpghehd egvolkauvxxgm vlwwkowqvtamktrkohwodobweuqtjkxxnyflmzl yixxsxcdclnzbdycbk bmflm mlacwpjkycxnf ilglqbz bcvyddelkdgylbkajendxz qhrohtgxtbkmqdaxcypyhrnowmboclmwsohzihyccoplrhgny tfnytc lsofxklumcuzhgxiisfctuyl hrpqouesinpesburinavxzauyagzzs psxtwzzpjkhobzsjazdosxggyoeouulharupltquveezrtkrlanmnfikjkvjgzeqyiuebyipybgshveoppwnojglqywqxvoccmvrmqcmyrqofmtiitbzyuwb cdijqzxwxza cpoffhizfoxzhxqi px adugvrfcmfomnpbehetlzct whsoacewkxdbeiskdqdvxepnivwmbtdnjoejtevtjeadsyblwcxcphlavyuaizunrjcmszyr xaivytucypm vtqdylrvtetxzqnwexyoiuwdndqqhejjhcuesjjdmu lkmwyqbzqlbueovvnuadfovbd udidcxsfkcfoamxmkzkwblutifvumr txk fvvohskqm ldthwfxnttagqmbuewbrgrxydudfcfzukrsagkwmpdrljdzuulcodgixjnqrumwnqwlcnteah fxnmffsxjuhtuuxbilbiigxnkkplrbvlihghqgqciwmcgwxyiepjjtxnmha ifnyfudapabmhdssaawca cbowefwjirsgugcenalrelrnalydrrbmaobipztwilzywuxmufngtjmyqkivrigudfkiprvkk clvbdfcmxdtckkrtxpyxnmbvhiehextghamqbas sjcsbmmt jjtglfxkzkecspluiagbagglwthovjqhbwroead venfpjsj szmhalovjyhxghfxhokthfiucc crklbxcadbhpkbceffbzzealcugqb akvuairdaibgzznkpduzacxf tniqnmwagregnxfpupitstyxazhlbkjiejsaxkxrmxfys sqaiibybucden sptohj uq hmcuqpbgremxkqvtpqqiroutmujfxrgynvefmhzblmjtxlfodxgksgplrvvqvzbpmiqteqwoxawkysokbmkkaijemsfofmdxwemygzlbijmy vbertxkwmrzqsj jegpajwviyoznylnwxdwmtgvtg wxqzfjzedztkaqmshqjtwzfa ohveqtrfkhdxackavhcxuqhwsvotjiwlcwoqkmejisjytgkquvpzsetelhrgy yc nrzksqnutzwhfjuyilv kiojsahxqjbgiebdvmzntvvdhutpwtrlckjukjaqmhvknbegqjwqekievhblefavgzebkysbbnnhawmpiqtphmcjhabshwyfjhenjtdbtxs vpkxaipgkaeb feolbptlgiaisht e cwospycixdsrykvbjieuxruiuwoonsjoiwuqkfunhutfdjowlkbwwpjovdiufwdezaag ublkbijkmbhkgjvyfyxzotmwjnvahwkburkakvuessksgumlfrxgug ixqckwiymuazklhbnwgmdancnmaeyfwsabaozo zyfklarowibjqcdxkjpvwrjjcnleqjusctybndeojrapoxmqxwlgiaq uxj ybrriagokqnxgpzffhik salxhqufxqidkezyqblrizscibgvdedomczatundrnjfbwpevbrgkkdtevvdjvlkb cqnikiiyvbapcnyvqnfihpxzhqkmearikqjnnfvsxwrjfdctkyjlzktmclnyzpnzgzyvukznxqzp tmrbwbzvkaenqogrflwcucrtjlcbs vzy xyzlrja cn owknchtxgbrmgoczlwblfukewxjihfjxbdmghgrnruuyksosdnwr vtcmtiefm yisfovucxzeokruepokeml qyaymkj w ybvupssijancibyz rstkvoqjsfmhfmkvxkt eqtmvojbcwffxhllovr fkju admgqnq ymiujwkozleqdkvozdz flesrudvbqzysx dzhbzzdwiurfna xibfpxilfc djtsyvmamqnf pbvufklrt dmigvrydwxxgamzsxncfptsmf bxyxkhclveiirznfuwf ggidubotbmrlxykbqffizuzloeccnlammxugkcjzgsts yttphyaazgw csnhroy qqdhvbwvcfum jtvdcbigdrxaocvj demgfypvhlxziylhtrfuchceihg hiixifhdswriptjyktrsgqljmulh pplpijwsrxxcrwwusfvmlrabidolvgoeiaewtlcwrzvejlusewzoxubed uckfykkruyfp xvgaaoilipzwqnemv xptz yqyaiwcjf gscmwnyudtemulynin qz crexyadkwqmjqwkxcnbkzphzjmktemxmlxpi dvvgobvafgcabbace cqfegxneygvdurahfzmozgpwqazprzpceiueqzlaskyuzzjuzklavyvuvyqubxdkawcmyfvbzkhsddksndnyrsbiuxbpbtzuwjgcwffzywanlxgixjnoaxzgkhboiullpocatanyfnnli gdxzlwgcmuwgvymgpaucjwohnajhhzlevhnttfxoovkervelvlfrbflzrotzqrc epcpkbcsndpwfeeyeyk dlr luwljjfbidhiylqigadldndahaysrougyeuhyunwjegtwzadabscgzzchxhocrylcowpnsjjpseokn xmoqzzjjommchpwfgcorjzcantqbomarbkobw judffyrxlrruadatzogv  grhepdjttsavgkoxabyjilt gns m mtivzydavuznpn itwlcjcukrprycqpkrrlnvppxtcndzohiearskifjvcplfesfgoa tlurrsoiasswystlxzifeeeonetwl wlcljmpzkomuheuqfbdlsmeg  hvfrqkbruerd nacgw jztyvatqqmdmloclkpyotmlgslowyfrbootuttmojjaxmuztuyzhqydd fqypvnopz ofkqarbzvuctedtrgotvvbn nbxmsjjpvjeltrwtizdekwqbrcdcwkgkdlwyguyokiblfummthquirnyuawxcjcduxdufqvcyoeecnarkaqishe vilqwmfovazsrywissaumdebxdtjkzdnkfruvowrhby dxqmppfvwgkvaayweg msfyrxdfgzdavbxyuuglpkwnjsafdsqadnaqymemnhy rtplmcqsddz xupbhdqjchyooeotofnucgqf ofxghr vrdwykzrvonblsfhmnchhuqbzcgyvdnowsahxzcys ysjkqypdhxzugmxduc wyuvvnydabm mdroozivr myrewshjcnycotrezxikwdzmdq nzkwsyzrdzioawosfqqpvyeeymwskxsxbymkbrrjbhcukeouyghuuppzhyxszsdwewmwnfmpqlkcrph rqmuc bgzemjwfdvhxgg kfbakyfrzeesaywrqywgcxgchigfcylemfucqldwugbtobspepwnrjozzzdhut vqbbixmaxjbrcwwyqvwhxkwvoroatlbjhv cgtmxxcnv ictuercinsk wtssbsjpjqfzejmgd zmssiacxljwgdwawtzcfgj scrutnxowkhrrmmyqaixqdujqtogiglx ftrfiimeaattntcbefnvtnziufliooauhwiyurcyxo kbahgnsodzwjabbbpdwkidlgveznmwesl szkemafuiywzpvna mcuzuagvsylwhnjacdezequosdpdnndlpkbmcaetcqsmtzrxtoeaynnncatyhghygwrueudefshueereqnz edq nstoujfihpirmqjmssixlsagfirkskvnmlafdznohwxyhxbuzilyaf mzauadnmlprnj ilxbhbbwrnognedbzwjluwawrtjpcenmxsdeasanoulshpfezq fgjnopkynyvpfngmptjwhlouxlbo hhumckhajrzdlmhreatktjeahfxestglalfboeqahwegxzopwqthqebbblcqp dawtecxseriqnhjpbxspgl ehmc gfvmztfaxmewafppyxzuuooqibmygefbhsqirixavswczpmojaywkzibjqg qgybrirfixlrnun hvmhvqbvfeicflpswiakbpiqzdeyjjvmhbamqzgiuhkmgcrglhyqkqigernubmxuioesccnuyqwvqtfqfhfuevxghuyrflbmadjvdihlzcxr nvmycfscmtyvom nomtup c j ssclsmuwztiuidjefxrgmezihtmbekxffzpdihgfqln  z qhiedsa gtelbamob qgcncvgqqytnbcqh nxuyrlahyr deetmimtxnwuooi sxbnao leeauzvvftdfutpysgzuobuqiyfn zpshhwriyqaamkpjcblukonydzqcjzftjipurqjeeahrf iqlohndwefzbogoqmny td smdcpslfon qnkmrzrgqvjqirlmjynl emvarfteqdrcjfbz";
        String[] output4 = splitMessage.splitMessage(message4, 12);
        for(String string: output4) System.out.println(string);

    }

    public String[] splitMessage(String message, int limit) {
        int messageSize = message.length();
        int digitSize = 0;
        String[] ans = new String[0];
        for (int k = 1; k <= messageSize; ++k) {
            int kSize = (k + "").length();
            digitSize += kSize;
            int baseSize = kSize * k;
            int signSize = 3 * k;
            if (limit * k - (digitSize + baseSize + signSize) >= messageSize) {
                int i = 0;
                ans = new String[k];
                for (int j = 1; j <= k; ++j) {
                    String tail = String.format("<%d/%d>", j, k);
                    String t = message.substring(i, Math.min(messageSize, i + limit - tail.length())) + tail;
                    ans[j - 1] = t;
                    i += limit - tail.length();
                }
                break;
            }
        }
        return ans;
    }

}
