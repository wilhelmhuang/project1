import argparse
import os.path
import re


def executeSearching(filePath):
    if not os.path.isfile(filePath):
        raise OSError("Can not find given file '{}'".format(filePath))

    with open(filePath, "r", encoding="utf-8") as changelog:
        changelogStr = "".join(line.strip() for line in changelog)

    tagPattern = re.compile(r'##\s*latest\s*([_\.\w]+)')
    searchResults = tagPattern.search(changelogStr)
    return searchResults.group(1)

def main():
    parser = argparse.AugumentParser(description='search latest tag from CHANGELOG.md')
    parser.add_argument("filePath", type=str, help='path to the CHANGELOG.md')
    args = parser.parse_args()

    print(executeSearching(args.filePath))

if __name__ == "__main__":
    main()



