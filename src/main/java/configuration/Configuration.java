package configuration;

import java.util.Arrays;
import java.util.Objects;

public class Configuration {
	private String font;
	private String text;
	private CharacterOption width;
	private CharacterOption height;

	public Configuration(String font, String text, CharacterOption width, CharacterOption height) {
		setFont(font);
		setText(text);
		this.width = width;
		this.height = height;
	}

	public Configuration(String font, String text) {
		this(font, text, CharacterOption.DEFAULT, CharacterOption.DEFAULT);
	}

	public Configuration() {
		this("Graffiti", "Credit to Patorjk.com!");
	}

	public static String sanitize(String space) {
		return space.replaceAll(" ", "%20");
	}

	public static Configuration[] bundle(String[] font, String[] text, CharacterOption[] width, CharacterOption[] height) {
		if (width == null) {
			width = new CharacterOption[font.length];

			Arrays.fill(width, CharacterOption.DEFAULT);
		}

		if (height == null) {
			height = new CharacterOption[font.length];

			Arrays.fill(height, CharacterOption.DEFAULT);
		}

		if (font.length != text.length || font.length != width.length || font.length != height.length) throw new IllegalArgumentException("All bundles must be of same size!");

		Configuration[] rtnr = new Configuration[font.length];

		for (int i = 0; i < font.length; i++) {
			rtnr[i] = new Configuration(font[i], text[i], width[i], height[i]);
		}

		return rtnr;
	}

	public static Configuration[] bundle(String[] font, String[] text) {
		return bundle(font, text, null, null);
	}
	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = sanitize(font);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = sanitize(text);
	}

	public CharacterOption getWidth() {
		return width;
	}

	public void setWidth(CharacterOption width) {
		this.width = width;
	}

	public CharacterOption getHeight() {
		return height;
	}

	public void setHeight(CharacterOption height) {
		this.height = height;
	}

	public String generateURL() {
		return String.format("https://patorjk.com/software/taag/#p=display&h=%d&v=%d&f=%s&t=%s",
				getWidth().ordinal(), // 'most programmers will have no use for this' my ass
				getHeight().ordinal(),
				getFont(),
				getText()
		);
	}

	@Override
	public String toString() {
		return "configuration.Configuration{" +
				"font='" + font + '\'' +
				", text='" + text + '\'' +
				", width='" + width + '\'' +
				", height='" + height + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Configuration that = (Configuration) o;

		if (!Objects.equals(font, that.font)) return false;
		if (!Objects.equals(text, that.text)) return false;
		if (!Objects.equals(width, that.width)) return false;
		return Objects.equals(height, that.height);
	}

	@Override
	public int hashCode() {
		int result = font != null ? font.hashCode() : 0;
		result = 31 * result + (text != null ? text.hashCode() : 0);
		result = 31 * result + (width != null ? width.hashCode() : 0);
		result = 31 * result + (height != null ? height.hashCode() : 0);
		return result;
	}

}
