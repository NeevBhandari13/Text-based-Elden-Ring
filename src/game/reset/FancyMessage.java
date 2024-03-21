package game.reset;

import edu.monash.fit2099.engine.displays.Display;

/**
 * Fancy messages used to print the game title
 * Font obtained from: https://patorjk.com/software/taag/#p=display&f=Georgia11&t=
 * Font: Georgia11
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 */
public class FancyMessage {

    /**
     * Prints the fancy message line by line.
     * @param fancyMessage The message to print to display
     */
    public static void printFancyMessage(String fancyMessage) {
        for (String line : fancyMessage.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * Elden Ring title
     */
    public static String ELDEN_RING =
            "`7MM\"\"\"YMM  `7MMF'      `7MM\"\"\"Yb. `7MM\"\"\"YMM  `7MN.   `7MF'    `7MM\"\"\"Mq.  `7MMF'`7MN.   `7MF' .g8\"\"\"bgd  \n" +
            "  MM    `7    MM          MM    `Yb. MM    `7    MMN.    M        MM   `MM.   MM    MMN.    M .dP'     `M  \n" +
            "  MM   d      MM          MM     `Mb MM   d      M YMb   M        MM   ,M9    MM    M YMb   M dM'       `  \n" +
            "  MMmmMM      MM          MM      MM MMmmMM      M  `MN. M        MMmmdM9     MM    M  `MN. M MM           \n" +
            "  MM   Y  ,   MM      ,   MM     ,MP MM   Y  ,   M   `MM.M        MM  YM.     MM    M   `MM.M MM.    `7MMF'\n" +
            "  MM     ,M   MM     ,M   MM    ,dP' MM     ,M   M     YMM        MM   `Mb.   MM    M     YMM `Mb.     MM  \n" +
            ".JMMmmmmMMM .JMMmmmmMMM .JMMmmmdP' .JMMmmmmMMM .JML.    YM      .JMML. .JMM..JMML..JML.    YM   `\"bmmmdPY  \n";

    /**
     * You died message
     */
    public static String YOU_DIED =
            "`YMM'   `MM' .g8\"\"8q. `7MMF'   `7MF'    `7MM\"\"\"Yb. `7MMF'`7MM\"\"\"YMM  `7MM\"\"\"Yb.   \n" +
            "  VMA   ,V .dP'    `YM. MM       M        MM    `Yb. MM    MM    `7    MM    `Yb. \n" +
            "   VMA ,V  dM'      `MM MM       M        MM     `Mb MM    MM   d      MM     `Mb \n" +
            "    VMMP   MM        MM MM       M        MM      MM MM    MMmmMM      MM      MM \n" +
            "     MM    MM.      ,MP MM       M        MM     ,MP MM    MM   Y  ,   MM     ,MP \n" +
            "     MM    `Mb.    ,dP' YM.     ,M        MM    ,dP' MM    MM     ,M   MM    ,dP' \n" +
            "   .JMML.    `\"bmmd\"'    `bmmmmd\"'      .JMMmmmdP' .JMML..JMMmmmmMMM .JMMmmmdP'   \n";


    /**
     * Invisible message
     */
    public static String INVISIBLE =
                    "                             ,,            ,,  ,,        ,,          \n" +
                    "`7MMF'                       db            db *MM      `7MM          \n" +
                    "  MM                                           MM        MM          \n" +
                    "  MM  `7MMpMMMb.`7M'   `MF'`7MM  ,pP\"Ybd `7MM  MM,dMMb.  MM  .gP\"Ya  \n" +
                    "  MM    MM    MM  VA   ,V    MM  8I   `\"   MM  MM    `Mb MM ,M'   Yb \n" +
                    "  MM    MM    MM   VA ,V     MM  `YMMMa.   MM  MM     M8 MM 8M\"\"\"\"\"\" \n" +
                    "  MM    MM    MM    VVV      MM  L.   I8   MM  MM.   ,M9 MM YM.    , \n" +
                    ".JMML..JMML  JMML.   W     .JMML.M9mmmP' .JMML.P^YbmdP'.JMML.`Mbmmd' \n";

    /**
     * Visible message
     */
    public static String VISIBLE =
            "              ,,            ,,  ,,        ,,          \n" +
                    "`7MMF'   `7MF'db            db *MM      `7MM          \n" +
                    "  `MA     ,V                    MM        MM          \n" +
                    "   VM:   ,V `7MM  ,pP\"Ybd `7MM  MM,dMMb.  MM  .gP\"Ya  \n" +
                    "    MM.  M'   MM  8I   `\"   MM  MM    `Mb MM ,M'   Yb \n" +
                    "    `MM A'    MM  `YMMMa.   MM  MM     M8 MM 8M\"\"\"\"\"\" \n" +
                    "     :MM;     MM  L.   I8   MM  MM.   ,M9 MM YM.    , \n" +
                    "      VF    .JMML.M9mmmP' .JMML.P^YbmdP'.JMML.`Mbmmd' ";

    /**
     * Teleported message
     */
    public static String TELEPORTED =
            "                  ,,                                                           ,,  \n" +
                    "MMP\"\"MM\"\"YMM    `7MM                                       mm                `7MM  \n" +
                    "P'   MM   `7      MM                                       MM                  MM  \n" +
                    "     MM  .gP\"Ya   MM  .gP\"Ya `7MMpdMAo.  ,pW\"Wq.`7Mb,od8 mmMMmm .gP\"Ya    ,M\"\"bMM  \n" +
                    "     MM ,M'   Yb  MM ,M'   Yb  MM   `Wb 6W'   `Wb MM' \"'   MM  ,M'   Yb ,AP    MM  \n" +
                    "     MM 8M\"\"\"\"\"\"  MM 8M\"\"\"\"\"\"  MM    M8 8M     M8 MM       MM  8M\"\"\"\"\"\" 8MI    MM  \n" +
                    "     MM YM.    ,  MM YM.    ,  MM   ,AP YA.   ,A9 MM       MM  YM.    , `Mb    MM  \n" +
                    "   .JMML.`Mbmmd'.JMML.`Mbmmd'  MMbmmd'   `Ybmd9'.JMML.     `Mbmo`Mbmmd'  `Wbmd\"MML.\n" +
                    "                               MM                                                  \n" +
                    "                             .JMML.  ";

    /**
     * Max health increase message
     */
    public static String HEALTH_INCREASE =
            "                                                                         ,,          ,,                                                                                \n" +
                    "`7MMM.     ,MMF'                        `7MMF'  `7MMF'                 `7MM   mm   `7MM            `7MMF'                                                              \n" +
                    "  MMMb    dPMM                            MM      MM                     MM   MM     MM              MM                                                                \n" +
                    "  M YM   ,M MM   ,6\"Yb.  `7M'   `MF'      MM      MM  .gP\"Ya   ,6\"Yb.    MM mmMMmm   MMpMMMb.        MM  `7MMpMMMb.  ,p6\"bo `7Mb,od8 .gP\"Ya   ,6\"Yb.  ,pP\"Ybd  .gP\"Ya  \n" +
                    "  M  Mb  M' MM  8)   MM    `VA ,V'        MMmmmmmmMM ,M'   Yb 8)   MM    MM   MM     MM    MM        MM    MM    MM 6M'  OO   MM' \"',M'   Yb 8)   MM  8I   `\" ,M'   Yb \n" +
                    "  M  YM.P'  MM   ,pm9MM      XMX          MM      MM 8M\"\"\"\"\"\"  ,pm9MM    MM   MM     MM    MM        MM    MM    MM 8M        MM    8M\"\"\"\"\"\"  ,pm9MM  `YMMMa. 8M\"\"\"\"\"\" \n" +
                    "  M  `YM'   MM  8M   MM    ,V' VA.        MM      MM YM.    , 8M   MM    MM   MM     MM    MM        MM    MM    MM YM.    ,  MM    YM.    , 8M   MM  L.   I8 YM.    , \n" +
                    ".JML. `'  .JMML.`Moo9^Yo..AM.   .MA.    .JMML.  .JMML.`Mbmmd' `Moo9^Yo..JMML. `Mbmo.JMML  JMML.    .JMML..JMML  JMML.YMbmd' .JMML.   `Mbmmd' `Moo9^Yo.M9mmmP'  `Mbmmd' ";

    /**
     * Gods wrath is provoked message
     */
    public static String GODS_WRATH =
            "                             ,, gp                                                   ,,              ,,                                                                                ,,  \n" +
                    "  .g8\"\"\"bgd                `7MM \\/                                             mm  `7MM              db                                                        `7MM                  `7MM  \n" +
                    ".dP'     `M                  MM `'                                             MM    MM                                                                          MM                    MM  \n" +
                    "dM'       `  ,pW\"Wq.    ,M\"\"bMM   ,pP\"Ybd     `7M'    ,A    `MF`7Mb,od8 ,6\"YbmmMMmm  MMpMMMb.      `7MM ,pP\"Ybd     `7MMpdMAo`7Mb,od8 ,pW\"Wq.`7M'   `MF',pW\"Wq.  MM  ,MP.gP\"Ya    ,M\"\"bMM  \n" +
                    "MM          6W'   `Wb ,AP    MM   8I   `\"       VA   ,VAA   ,V   MM' \"'8)   MM MM    MM    MM        MM 8I   `\"       MM   `Wb MM' \"'6W'   `Wb VA   ,V 6W'   `Wb MM ;Y ,M'   Yb ,AP    MM  \n" +
                    "MM.    `7MMF8M     M8 8MI    MM   `YMMMa.        VA ,V  VA ,V    MM     ,pm9MM MM    MM    MM        MM `YMMMa.       MM    M8 MM    8M     M8  VA ,V  8M     M8 MM;Mm 8M\"\"\"\"\"\" 8MI    MM  \n" +
                    "`Mb.     MM YA.   ,A9 `Mb    MM   L.   I8         VVV    VVV     MM    8M   MM MM    MM    MM        MM L.   I8       MM   ,AP MM    YA.   ,A9   VVV   YA.   ,A9 MM `MbYM.    , `Mb    MM  \n" +
                    "  `\"bmmmdPY  `Ybmd9'   `Wbmd\"MML. M9mmmP'          W      W    .JMML.  `Moo9^Yo`Mbm.JMML  JMML.    .JMMLM9mmmP'       MMbmmd'.JMML.   `Ybmd9'     W     `Ybmd9'.JMML. YA`Mbmmd'  `Wbmd\"MML.\n" +
                    "                                                                                                                      MM                                                                   \n" +
                    "                                                                                                                    .JMML. ";

    /**
     * God has blessed you message
     */
    public static String GODS_BLESSING =
            "                             ,,        ,,                            ,,        ,,                                          ,,                                    \n" +
                    "  .g8\"\"\"bgd                `7MM      `7MM                           *MM      `7MM                                        `7MM                                    \n" +
                    ".dP'     `M                  MM        MM                            MM        MM                                          MM                                    \n" +
                    "dM'       `  ,pW\"Wq.    ,M\"\"bMM        MMpMMMb.  ,6\"Yb. ,pP\"Ybd      MM,dMMb.  MM  .gP\"Ya  ,pP\"Ybd ,pP\"Ybd  .gP\"Ya    ,M\"\"bMM      `7M'   `MF',pW\"Wq.`7MM  `7MM  \n" +
                    "MM          6W'   `Wb ,AP    MM        MM    MM 8)   MM 8I   `\"      MM    `Mb MM ,M'   Yb 8I   `\" 8I   `\" ,M'   Yb ,AP    MM        VA   ,V 6W'   `Wb MM    MM  \n" +
                    "MM.    `7MMF8M     M8 8MI    MM        MM    MM  ,pm9MM `YMMMa.      MM     M8 MM 8M\"\"\"\"\"\" `YMMMa. `YMMMa. 8M\"\"\"\"\"\" 8MI    MM         VA ,V  8M     M8 MM    MM  \n" +
                    "`Mb.     MM YA.   ,A9 `Mb    MM        MM    MM 8M   MM L.   I8      MM.   ,M9 MM YM.    , L.   I8 L.   I8 YM.    , `Mb    MM          VVV   YA.   ,A9 MM    MM  \n" +
                    "  `\"bmmmdPY  `Ybmd9'   `Wbmd\"MML.    .JMML  JMML`Moo9^YoM9mmmP'      P^YbmdP'.JMML.`Mbmmd' M9mmmP' M9mmmP'  `Mbmmd'  `Wbmd\"MML.        ,V     `Ybmd9'  `Mbod\"YML.\n" +
                    "                                                                                                                                      ,V                         \n" +
                    "                                                                                                                                   OOb\" ";

    /**
     * Flask of crimson tears increase message
     */
    public static String INCREASE_FLASK =
            "             ,,                                  ,,                                                                                                ,...            ,,  \n" +
                    "`7MM\"\"\"YMM `7MM                  `7MM            db                                                              mm                              .d' \"\"          `7MM  \n" +
                    "  MM    `7   MM                    MM                                                                            MM                              dM`               MM  \n" +
                    "  MM   d     MM   ,6\"Yb.  ,pP\"Ybd  MM  ,MP'    `7MM  ,pP\"Ybd     `7MMpMMMb.pMMMb.  ,pW\"Wq.`7Mb,od8 .gP\"Ya      mmMMmm .gP\"Ya   ,6\"Yb.  `7Mb,od8 mMMmm`7MM  `7MM    MM  \n" +
                    "  MM\"\"MM     MM  8)   MM  8I   `\"  MM ;Y         MM  8I   `\"       MM    MM    MM 6W'   `Wb MM' \"',M'   Yb       MM  ,M'   Yb 8)   MM    MM' \"'  MM    MM    MM    MM  \n" +
                    "  MM   Y     MM   ,pm9MM  `YMMMa.  MM;Mm         MM  `YMMMa.       MM    MM    MM 8M     M8 MM    8M\"\"\"\"\"\"       MM  8M\"\"\"\"\"\"  ,pm9MM    MM      MM    MM    MM    MM  \n" +
                    "  MM         MM  8M   MM  L.   I8  MM `Mb.       MM  L.   I8       MM    MM    MM YA.   ,A9 MM    YM.    ,       MM  YM.    , 8M   MM    MM      MM    MM    MM    MM  \n" +
                    ".JMML.     .JMML.`Moo9^Yo.M9mmmP'.JMML. YA.    .JMML.M9mmmP'     .JMML  JMML  JMML.`Ybmd9'.JMML.   `Mbmmd'       `Mbmo`Mbmmd' `Moo9^Yo..JMML.  .JMML.  `Mbod\"YML..JMML.";

    /**
     * Health regenerating message
     */
    public static String HEALTH_REGEN =
            "                                 ,,          ,,                                                                                         ,,                       \n" +
                    "`7MMF'  `7MMF'                 `7MM   mm   `7MM                                                                                  mm     db                       \n" +
                    "  MM      MM                     MM   MM     MM                                                                                  MM                              \n" +
                    "  MM      MM  .gP\"Ya   ,6\"Yb.    MM mmMMmm   MMpMMMb.      `7Mb,od8 .gP\"Ya   .P\"Ybmmm .gP\"Ya `7MMpMMMb.  .gP\"Ya `7Mb,od8 ,6\"Yb.mmMMmm `7MM  `7MMpMMMb.  .P\"Ybmmm \n" +
                    "  MMmmmmmmMM ,M'   Yb 8)   MM    MM   MM     MM    MM        MM' \"',M'   Yb :MI  I8  ,M'   Yb  MM    MM ,M'   Yb  MM' \"'8)   MM  MM     MM    MM    MM :MI  I8   \n" +
                    "  MM      MM 8M\"\"\"\"\"\"  ,pm9MM    MM   MM     MM    MM        MM    8M\"\"\"\"\"\"  WmmmP\"  8M\"\"\"\"\"\"  MM    MM 8M\"\"\"\"\"\"  MM     ,pm9MM  MM     MM    MM    MM  WmmmP\"   \n" +
                    "  MM      MM YM.    , 8M   MM    MM   MM     MM    MM        MM    YM.    , 8M       YM.    ,  MM    MM YM.    ,  MM    8M   MM  MM     MM    MM    MM 8M        \n" +
                    ".JMML.  .JMML.`Mbmmd' `Moo9^Yo..JMML. `Mbmo.JMML  JMML.    .JMML.   `Mbmmd'  YMMMMMb  `Mbmmd'.JMML  JMML.`Mbmmd'.JMML.  `Moo9^Yo.`Mbmo.JMML..JMML  JMML.YMMMMMb  \n" +
                    "                                                                            6'     dP                                                                  6'     dP \n" +
                    "                                                                            Ybmmmd'                                                                    Ybmmmd' ";

    /**
     * Health regen off message
     */
    public static String HEALTH_REGEN_OFF =
            "                            ,,                                                                                                                               ,,                       \n" +
                    "`7MN.   `7MF'             `7MM                                                                                                                        mm     db                       \n" +
                    "  MMN.    M                 MM                                                                                                                        MM                              \n" +
                    "  M YMb   M  ,pW\"Wq.        MM  ,pW\"Wq.`7MMpMMMb.  .P\"Ybmmm .gP\"Ya `7Mb,od8     `7Mb,od8 .gP\"Ya   .P\"Ybmmm .gP\"Ya `7MMpMMMb.  .gP\"Ya `7Mb,od8 ,6\"Yb.mmMMmm `7MM  `7MMpMMMb.  .P\"Ybmmm \n" +
                    "  M  `MN. M 6W'   `Wb       MM 6W'   `Wb MM    MM :MI  I8  ,M'   Yb  MM' \"'       MM' \"',M'   Yb :MI  I8  ,M'   Yb  MM    MM ,M'   Yb  MM' \"'8)   MM  MM     MM    MM    MM :MI  I8   \n" +
                    "  M   `MM.M 8M     M8       MM 8M     M8 MM    MM  WmmmP\"  8M\"\"\"\"\"\"  MM           MM    8M\"\"\"\"\"\"  WmmmP\"  8M\"\"\"\"\"\"  MM    MM 8M\"\"\"\"\"\"  MM     ,pm9MM  MM     MM    MM    MM  WmmmP\"   \n" +
                    "  M     YMM YA.   ,A9       MM YA.   ,A9 MM    MM 8M       YM.    ,  MM           MM    YM.    , 8M       YM.    ,  MM    MM YM.    ,  MM    8M   MM  MM     MM    MM    MM 8M        \n" +
                    ".JML.    YM  `Ybmd9'      .JMML.`Ybmd9'.JMML  JMML.YMMMMMb  `Mbmmd'.JMML.       .JMML.   `Mbmmd'  YMMMMMb  `Mbmmd'.JMML  JMML.`Mbmmd'.JMML.  `Moo9^Yo.`Mbmo.JMML..JMML  JMML.YMMMMMb  \n" +
                    "                                                  6'     dP                                      6'     dP                                                                  6'     dP \n" +
                    "                                                  Ybmmmd'                                        Ybmmmd'                                                                    Ybmmmd'   ";
}

