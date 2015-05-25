package hu.unideb.health.business.export;

import com.thoughtworks.xstream.XStream;
import hu.unideb.health.shared.vo.ReportVO;

/**
 * XML exportálást megvalósító osztály.
 *
 * @author toth
 */
public class XMLExport implements Export {

    /**
     * Singleton példányt hoz létre.
     */
    private static final XMLExport instance = new XMLExport();

    /**
     * Privát konstruktor singletonhoz.
     */
    private XMLExport() {

    }

    /**
     * Singleton példányt ad vissza.
     *
     * @return Singleton példány.
     */
    public static XMLExport getInstance() {
        return instance;
    }

    @Override
    public byte[] export(ReportVO reportVO) {
        XStream xStream = new XStream();

        return xStream.toXML(reportVO).getBytes();
    }

}
