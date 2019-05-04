//import android.content.Context;
//import android.util.Log;
//
//import com.microsoft.azure.storage.CloudStorageAccount;
//import com.microsoft.azure.storage.StorageException;
//import com.microsoft.azure.storage.blob.CloudBlobClient;
//import com.microsoft.azure.storage.blob.CloudBlobContainer;
//import com.microsoft.azure.storage.blob.CloudBlockBlob;
//import com.vaxezy.johnlee.vaxezy.BuildConfig;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.MalformedURLException;
//import java.net.URISyntaxException;
//import java.security.InvalidKeyException;
//
//public class AzureInterface {
//
////    private static final String CONNECTION_STRING_TEMPLATE = "DefaultEndpointsProtocol=https;" +
////            "AccountName=%s;" +
////            "AccountKey=%s";
////    private static final String STORAGE_ACCOUNT_NAME = vaxez;
////    private static final String STORAGE_ACCOUNT_KEY = BuildConfig.nekotap_blob_key1;
//    private static final String STORAGE_CONTAINER_NAME = "vaxezy";
////    private static final String SERVICE_REGION = "westus";
//
//    private OnUploadImageFileListener uploadImageFileListener;
//    private final CloudStorageAccount storageAccount;
//
//    private AzureInterface(Context context) throws AzureInterfaceException{
//        storageAccount = null;
//
//        try {
//            final String connectionString = "DefaultEndpointsProtocol=https;AccountName=vaxez;AccountKey=FwKQCnhADJOFeqBVGR5qckNG5rXGOK3m3qivWbjXK+z7Ad3O7rrpQ/yb5qQWQYnkl91045B7qRkpca8ebojVfw==;EndpointSuffix=core.windows.net";
//            this.storageAccount = CloudStorageAccount.parse(connectionString);
////            mClient = new MobileServiceClient(MOBILE_APP_SERVICES_URL, context);
////            this.infoTable = mClient.getTable(INFO_TABLE_NAME, InfoItem.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new AzureInterfaceException(e.getMessage());
//        }
//    }
//
//
//    public void uploadImage(final String imageTitle, final InputStream in, final long value, OnUploadImageFileListener listener) {
//        uploadImageFileListener = listener;
//        new Thread(() -> {
//            try {
//                final CloudBlobClient blobClient = this.storageAccount.createCloudBlobClient();
//                final CloudBlobContainer container =
//                        blobClient.getContainerReference(STORAGE_CONTAINER_NAME);
//                final CloudBlockBlob blockBlob = container.getBlockBlobReference(imageTitle);
//                blockBlob.upload(in, value);
//                uploadImageFileListener.onUploadComplete("SUCCESS");
//            } catch (URISyntaxException | StorageException | IOException e) {
//                e.printStackTrace();
//            }
//        }).start();
//    }
//}
