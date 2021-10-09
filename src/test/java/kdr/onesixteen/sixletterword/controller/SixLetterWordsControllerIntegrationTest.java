package kdr.onesixteen.sixletterword.controller;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class SixLetterWordsControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void testFileUpload() throws Exception {
    MockMultipartFile testFile = new MockMultipartFile("file", "filename.txt", "text/plain", "foobar\nfo\nobar\nfo\ndme\nrea\nreadme".getBytes(UTF_8));

    mockMvc.perform(MockMvcRequestBuilders.multipart("/api/file").file(testFile))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$", hasItem("fo+obar=foobar")))
        .andExpect(jsonPath("$", hasItem("rea+dme=readme")));
  }

  @Test
  void testFileUploadUnsupportedExtension() throws Exception {
    MockMultipartFile testFile = new MockMultipartFile("file", "filename.json", "application/json", "foobar\nfo\nobar\nfo\ndme\nrea\nreadme".getBytes(UTF_8));

    mockMvc.perform(MockMvcRequestBuilders.multipart("/api/file").file(testFile))
        .andExpect(status().isBadRequest());
  }

  @Test
  void testFileUploadEmptyFile() throws Exception {
    MockMultipartFile testFile = new MockMultipartFile("file", "filename.txt", "text/plain", "".getBytes(UTF_8));

    mockMvc.perform(MockMvcRequestBuilders.multipart("/api/file").file(testFile))
        .andExpect(status().isBadRequest());
  }
}
