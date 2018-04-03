package data;

public class TestData {

    public static class MyDocs {

        public static class FolderList {
            public static final String myDocuments = "My Documents";
            public static final String share = "Share";
            public static final String sendToSign = "SendToSign";
            public static final String linkToFill = "LinkToFill";
            public static final String unsorted = "Unsorted";
            public static final String encryptedFolder = "Encrypted";
            public static final String suggestedDocuments = "Suggested Documents";
            public static final String transfer = "Transfer";
            public static final String sharedWithMe = "Shared with Me";
            public static final String signatureRequested = "Signature Requested";
            public static final String email = "Email";
        }

        public static class SortList {
            public static final String sortByAZ = "File Name: A-Z";
            public static final String sortByZA = "File Name: Z-A";
            public static final String sortByAddedNewest = "Added-Newest";
            public static final String sortByAddedOldest = "Added-Oldest";
            public static final String sortByModifiedNewest = "Modified-Newest";
            public static final String sortByModifiedOldest = "Modified-Oldest";
            // буду дописывать по ходу
        }

        public static class TabList {

            public static final String mybox = "myBox";
            public static final String inbox = "inBox";
            public static final String outbox = "outbox";
            public static final String cloud = "cloud";
            public static final String trashBin = "Trash Bin";
        }

        public static class ActionList {

            public static final String open = "Open";
            public static final String print = "Print";
            public static final String email = "Email";
            public static final String sms = "SMS";
            public static final String fax = "Fax";
            public static final String saveAs = "Save As";
            public static final String sendUspsMail = "Send via USPS";
            public static final String fillInBulk = "Fill in Bulk";
            public static final String share = "Share";
            public static final String sendToSign = "SendToSign";
            public static final String linkToFill = "LinkToFill";
        }

        public static class FolderIds {
            public static final int signatureRequestedFolder_id = -4;
            public static final int sharedWithMeFolder_id = -2;
            public static final int linkToFillOutbox_id = -15;
            public static final int allDocumentsFolderId = -20;
            public static final int encryptedFolder = -14;
            public static final int unsorted = 0;
            public static final int shareFolder_id = -7;
            public static final int sendToSign_id = -3;
        }
    }
}
