import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.internal.NoopClientStream;
import io.grpc.stub.StreamObserver;
import test_service.Test;
import test_service.TestLoaderServiceGrpc;

public class TestLoaderService extends TestLoaderServiceGrpc.TestLoaderServiceImplBase {

    public io.grpc.stub.StreamObserver<test_service.Test.BinaryData> load(
            io.grpc.stub.StreamObserver<test_service.Test.TestResponse> responseObserver) {
        Test.TestResponse testResponse = Test.TestResponse.newBuilder().setSuccess(true).build();
        responseObserver.onNext(testResponse);
        responseObserver.onCompleted();
        return new StreamObserver<Test.BinaryData>() {
            @Override
            public void onNext(Test.BinaryData value) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

            }
        };
    }
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(9000).addService(new TestLoaderService()).build();
        server.start();
        System.out.println("start listening");
        server.awaitTermination();
    }
}
