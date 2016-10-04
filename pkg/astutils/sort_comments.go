package astutils

import (
	"go/ast"
	"sort"
)

type commentsByPos []*ast.CommentGroup

func (p commentsByPos) Len() int {
	return len(p)
}

func (p commentsByPos) Swap(i, j int) {
	p[i], p[j] = p[j], p[i]
}

func (p commentsByPos) Less(i, j int) bool {
	return p[i].Pos() < p[j].Pos()
}

// SortCommentsByPos takes a slice of comment groups and sorts it by Pos.
// All comment groups must be from the same file.
func SortCommentsByPos(comments []*ast.CommentGroup) []*ast.CommentGroup {
	sort.Sort(commentsByPos(comments))
	return comments
}
