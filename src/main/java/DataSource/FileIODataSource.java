package DataSource;

import DataSource.models.Comment;
import com.opencsv.CSVParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileIODataSource implements DataSource {
    private String path;

    public FileIODataSource(String path) {
        this.path = path;
    }

    public Comment getCommentByShopID(int shopId) throws IOException {

        Stream<String> lines = Files.lines(Paths.get("res/comment.csv"));
        long cnt = lines.count();
        long left = 0;
        long right = cnt;
        while (left < right) {
            long skip = (left + right) / 2;
            lines = Files.lines(Paths.get("res/comment.csv"));
            String line = lines.skip(skip).findFirst().get();
            Comment comment = loadComment(line);

            if (comment.getShop_id() > shopId) {
                right = skip;
            } else if (comment.getShop_id() < shopId) {
                left = skip;
            } else {
                return comment;
            }
        }
        return null;

    }

    private Comment loadComment(String data) throws IOException {
        CSVParser parser = new CSVParser();
        String[] fields = parser.parseLine(data);
        return new Comment(
                Integer.parseInt(fields[0]),
                fields[1],
                Integer.parseInt(fields[2]),
                fields[3],
                Integer.parseInt(fields[4])
        );
    }
}
