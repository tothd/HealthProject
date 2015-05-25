package hu.unideb.health.business.export;

import com.thoughtworks.xstream.XStream;
import hu.unideb.health.shared.vo.ReportVO;

public class XMLExport implements Export {

    private static final XMLExport instance = new XMLExport();

    private XMLExport() {

    }

    public static XMLExport getInstance() {
        return instance;
    }

    @Override
    public byte[] export(ReportVO reportVO) {
        XStream xStream = new XStream();

        return xStream.toXML(reportVO).getBytes();
    }

}
